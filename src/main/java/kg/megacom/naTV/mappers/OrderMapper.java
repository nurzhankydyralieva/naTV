package kg.megacom.naTV.mappers;

import kg.megacom.naTV.models.entities.Order;
import kg.megacom.naTV.models.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderDto orderDto);

    OrderDto toOrderDto(Order order);

    List<Order> toOrder(List<OrderDto> orderDtos);

    List<OrderDto> toOrderDtos(List<Order> orders);
}
