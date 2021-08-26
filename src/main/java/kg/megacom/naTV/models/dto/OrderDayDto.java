package kg.megacom.naTV.models.dto;

import kg.megacom.naTV.models.entities.OrderDetail;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDayDto {
    private Long id;
    private Date day;
    private OrderDetailDto orderDetail;
}
