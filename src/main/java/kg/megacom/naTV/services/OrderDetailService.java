package kg.megacom.naTV.services;

import kg.megacom.naTV.models.dto.OrderDetailDto;
import kg.megacom.naTV.models.dto.OrderDto;
import kg.megacom.naTV.models.entities.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetailDto save(OrderDetail orderDetail);
    List<OrderDetailDto> findAllByOrder(OrderDto saveOrder);

    List<OrderDetailDto> findByOrderId(Long id);
}
