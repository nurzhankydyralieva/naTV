package kg.megacom.naTV.services.impl;

import kg.megacom.naTV.dao.PriceRepo;
import kg.megacom.naTV.mappers.PriceMapper;
import kg.megacom.naTV.models.dto.PriceDto;
import kg.megacom.naTV.models.objects.InputPriceData;
import kg.megacom.naTV.services.ChannelService;
import kg.megacom.naTV.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepo priceRepo;
    @Autowired
    private ChannelService channelService;

    @Override
    public List<PriceDto> allActiveChannelPrices() {
        return PriceMapper.INSTANCE.toPriceDtos(priceRepo.allActiveChannelPrices());
    }

    @Override
    public PriceDto savePrice(InputPriceData inputPriceData) {
        PriceDto priceDto = new PriceDto();
        priceDto.setChannel(channelService.findChannelByIdForDiscount(inputPriceData.getChannelId()));
        priceDto.setPrice(inputPriceData.getPrice());
        priceDto.setStartDate(inputPriceData.getStarDate());
        priceDto.setEndDate(inputPriceData.getEndDate());
        return PriceMapper.INSTANCE.toPriceDto(priceRepo.save(PriceMapper.INSTANCE.toPrice(priceDto)));
    }

    @Override
    public PriceDto findChannelDate(Long id) {
        return PriceMapper.INSTANCE.toPriceDto(priceRepo.findChannelDate(id));
    }


}
