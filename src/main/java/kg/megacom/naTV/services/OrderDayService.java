package kg.megacom.naTV.services;

import kg.megacom.naTV.models.dto.OrderDayDto;
import kg.megacom.naTV.models.dto.OrderDetailDto;

import java.util.Date;
import java.util.List;

public interface OrderDayService {

    void save(Date date, OrderDetailDto orderDetailDto);
    List<OrderDayDto> findByOrderDetailId(Long id);
}
