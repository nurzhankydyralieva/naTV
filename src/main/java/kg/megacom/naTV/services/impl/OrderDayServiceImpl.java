package kg.megacom.naTV.services.impl;

import kg.megacom.naTV.dao.OrderDayRepo;
import kg.megacom.naTV.mappers.OrderDayMapper;
import kg.megacom.naTV.mappers.OrderDetailMapper;
import kg.megacom.naTV.models.dto.OrderDayDto;
import kg.megacom.naTV.models.dto.OrderDetailDto;
import kg.megacom.naTV.services.OrderDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class OrderDayServiceImpl implements OrderDayService {
    @Autowired
    private OrderDayRepo orderDayRepo;

    @Override
    public void save(Date date, OrderDetailDto orderDetailDto) {
        OrderDayDto orderDayDto = new OrderDayDto();
        orderDayDto.setDay(date);
        orderDayDto.setOrderDetail(orderDetailDto);
        orderDayRepo.save(OrderDayMapper.INSTANCE.toOrderDay(orderDayDto));
    }

    @Override
    public List<OrderDayDto> findByOrderDetailId(Long id) {
        return OrderDayMapper.INSTANCE.toOrderDayDtos(orderDayRepo.findByOrderDetailId(id));
    }
}
