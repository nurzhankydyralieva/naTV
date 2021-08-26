package kg.megacom.naTV.mappers;

import kg.megacom.naTV.models.entities.Price;
import kg.megacom.naTV.models.dto.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    Price toPrice(PriceDto priceDto);

    PriceDto toPriceDto(Price price);

    List<Price> toPrice(List<PriceDto> priceDtos);

    List<PriceDto> toPriceDtos(List<Price> prices);

}
