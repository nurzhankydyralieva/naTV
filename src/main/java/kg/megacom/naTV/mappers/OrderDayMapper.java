package kg.megacom.naTV.mappers;

import kg.megacom.naTV.models.entities.OrderDay;
import kg.megacom.naTV.models.dto.OrderDayDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderDayMapper {
    OrderDayMapper INSTANCE = Mappers.getMapper(OrderDayMapper.class);

    OrderDay toOrderDay(OrderDayDto orderDayDto);

    OrderDayDto toOrderDayDto(OrderDay orderDay);

    List<OrderDay> toOrderDays(List<OrderDayDto> orderDayDtos);

    List<OrderDayDto> toOrderDayDtos(List<OrderDay> orderDays);
}
