package kg.megacom.naTV.models.dto;

import kg.megacom.naTV.models.entities.Channel;
import lombok.Data;

@Data
public class OrderDetailDto {
    private Long id;
    private ChannelDto channel;
    private OrderDto order;
    private double price;
}
