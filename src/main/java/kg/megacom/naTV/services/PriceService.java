package kg.megacom.naTV.services;

import kg.megacom.naTV.models.dto.PriceDto;
import kg.megacom.naTV.models.objects.InputPriceData;

import java.util.List;

public interface PriceService {
    List<PriceDto> allActiveChannelPrices();
    PriceDto savePrice(InputPriceData inputPriceData);
    PriceDto findChannelDate(Long id);
}
