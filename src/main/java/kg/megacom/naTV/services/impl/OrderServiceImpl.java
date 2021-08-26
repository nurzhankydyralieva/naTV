package kg.megacom.naTV.services.impl;

import kg.megacom.naTV.dao.OrderRepo;
import kg.megacom.naTV.enums.OrderStatus;
import kg.megacom.naTV.mappers.OrderDetailMapper;
import kg.megacom.naTV.mappers.OrderMapper;
import kg.megacom.naTV.models.dto.*;
import kg.megacom.naTV.models.entities.Order;
import kg.megacom.naTV.models.objects.ChannelOrderData;
import kg.megacom.naTV.models.objects.InputChannelData;
import kg.megacom.naTV.models.objects.InputOrderData;
import kg.megacom.naTV.models.objects.OrderResponse;
import kg.megacom.naTV.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ChannelService channelService;
    @Autowired
    private DiscountService discountService;
    @Autowired
    private PriceService priceService;
    @Autowired
    private OrderDayService orderDayService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Override
    public OrderResponse saveOrder(InputOrderData inputOrderData) {
        OrderResponse orderResponse = new OrderResponse();
        Order order = new Order();
        order.setText(inputOrderData.getAddText());
        order.setName(inputOrderData.getClientName());
        order.setPhone(inputOrderData.getClientPhone());
        order.setEmail(inputOrderData.getClientEmail());
        order.setEditDate(new Date());
        order.setAddDate(new Date());
        order.setStatus(OrderStatus.IN_PROGRESS);
        OrderDto saving = OrderMapper.INSTANCE.toOrderDto(orderRepo.save(order));
        String lengthText = order.getText().replaceAll("\\s", "");
        double totalPrice;

        List<InputChannelData> inputChannelDataList = inputOrderData.getChannels();
        for (InputChannelData i : inputChannelDataList) {
            OrderDetailDto orderDetailDto = new OrderDetailDto();
            orderDetailDto.setOrder(saving);
            orderDetailDto.setChannel(channelService.findChannelByIdForDiscount(i.getChannelId()));
            int days = i.getDays().size();
            DiscountDto discountDto = discountService.findChannelAndMinDay(days, i.getChannelId());
            PriceDto priceDto = priceService.findChannelDate(i.getChannelId());
            double pricePerSymbol = priceDto.getPrice();
            int addText = lengthText.length();

            OrderDetailDto orderDetailDto1;
            if (discountDto != null) {
                double percent = discountDto.getPercent();
                double withNoDiscount = pricePerSymbol * addText;
                double discountTotal = withNoDiscount * percent / 100;
                double sumChannel = (withNoDiscount - discountTotal) * days;
                orderDetailDto.setPrice(sumChannel);
                orderDetailDto1 = orderDetailService.save(OrderDetailMapper.INSTANCE.toOrderDetail(orderDetailDto));
            } else {
                double withNoDiscount = (pricePerSymbol * addText) * days;
                orderDetailDto.setPrice(withNoDiscount);
                orderDetailDto1 = orderDetailService.save(OrderDetailMapper.INSTANCE.toOrderDetail(orderDetailDto));
            }
            List<Date> date = i.getDays();
            date.forEach(d -> {
                orderDayService.save(d, orderDetailDto1);
            });
        }
        List<OrderDetailDto> orderDetailDtos = orderDetailService.findAllByOrder(saving);
        totalPrice = orderDetailDtos.stream().mapToDouble(x -> x.getPrice()).sum();
        saving.setTotalPrice(totalPrice);
        Order order1 = orderRepo.save(OrderMapper.INSTANCE.toOrder(saving));
        orderResponse.setOrderCost(totalPrice);
        orderResponse.setAddText(order1.getText());
        orderResponse.setPaymentCode((long) ((Math.random() * (9999 - 1000)) + 1000));
        List<OrderDetailDto> orderDetailDtoList = orderDetailService.findByOrderId(order1.getId());
        List<ChannelOrderData> channelOrderData = new ArrayList<>();
        for (OrderDetailDto o : orderDetailDtoList) {
            ChannelOrderData channelOrderData1 = new ChannelOrderData();
            channelOrderData1.setCostPerChannel(o.getPrice());
            ChannelDto channelDto = channelService.findChannelByIdForDiscount(o.getChannel().getId());
            channelOrderData1.setChannelName(channelDto.getChannelName());
            List<OrderDayDto> orderDayDtos = orderDayService.findByOrderDetailId(o.getId());
            List<Date> dates = new ArrayList<>();
            for (OrderDayDto od: orderDayDtos){
                Date date;
                date = od.getDay();
                dates.add(date);
            }
            channelOrderData1.setDates(dates);
            channelOrderData.add(channelOrderData1);
        }
        orderResponse.setChannels(channelOrderData);
        return orderResponse;
    }
}
