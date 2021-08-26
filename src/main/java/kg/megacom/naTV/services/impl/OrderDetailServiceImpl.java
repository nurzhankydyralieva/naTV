package kg.megacom.naTV.services.impl;

import kg.megacom.naTV.dao.OrderDetailRepo;
import kg.megacom.naTV.mappers.OrderDetailMapper;
import kg.megacom.naTV.mappers.OrderMapper;
import kg.megacom.naTV.models.dto.OrderDetailDto;
import kg.megacom.naTV.models.dto.OrderDto;
import kg.megacom.naTV.models.entities.OrderDetail;
import kg.megacom.naTV.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Override
    public OrderDetailDto save(OrderDetail orderDetail) {
        return OrderDetailMapper.INSTANCE.toOrderDetailDto(orderDetailRepo.save(orderDetail));
    }

    @Override
    public List<OrderDetailDto> findAllByOrder(OrderDto saveOrder) {
        List<OrderDetail> orderDetails = orderDetailRepo.findAllByOrder(OrderMapper.INSTANCE.toOrder(saveOrder));
        return OrderDetailMapper.INSTANCE.toOrderDetailDtos(orderDetails);
    }

    @Override
    public List<OrderDetailDto> findByOrderId(Long id) {
        return OrderDetailMapper.INSTANCE.toOrderDetailDtos(orderDetailRepo.findByOrderId(id));
    }


}
