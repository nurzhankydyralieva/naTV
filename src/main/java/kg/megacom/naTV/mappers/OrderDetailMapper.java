package kg.megacom.naTV.mappers;

import kg.megacom.naTV.models.entities.OrderDetail;
import kg.megacom.naTV.models.dto.OrderDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

    OrderDetailDto toOrderDetailDto(OrderDetail orderDetail);

    OrderDetail toOrderDetail(OrderDetailDto orderDetailDto);

    List<OrderDetail> toOrderDetail(List<OrderDetailDto> orderDetailDtos);

    List<OrderDetailDto> toOrderDetailDtos(List<OrderDetail> orderDetails);
}
