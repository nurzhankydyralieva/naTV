package kg.megacom.naTV.mappers;

import kg.megacom.naTV.models.entities.Discount;
import kg.megacom.naTV.models.dto.DiscountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DiscountMapper {
    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

    Discount toDiscount(DiscountDto discountDto);

    DiscountDto toDiscountDto(Discount discount);

    List<Discount> toDiscounts(List<DiscountDto> discountDtos);

    List<DiscountDto> toDiscountDtos(List<Discount> discounts);
}
