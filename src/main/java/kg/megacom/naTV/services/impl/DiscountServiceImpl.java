package kg.megacom.naTV.services.impl;

import kg.megacom.naTV.dao.DiscountRepo;
import kg.megacom.naTV.mappers.DiscountMapper;
import kg.megacom.naTV.models.dto.DiscountDto;
import kg.megacom.naTV.models.objects.InputDiscountData;
import kg.megacom.naTV.models.objects.InputOrderData;
import kg.megacom.naTV.services.ChannelService;
import kg.megacom.naTV.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    private DiscountRepo discountRepo;
    @Autowired
    private ChannelService channelService;

    @Override
    public List<DiscountDto> allChannelWithD(Long id) {
        return DiscountMapper.INSTANCE.toDiscountDtos(discountRepo.allActiveChannelD(id));
    }

    @Override
    public DiscountDto findChannelAndMinDay(int days, Long id) {
        return DiscountMapper.INSTANCE.toDiscountDto(discountRepo.findChannelAndMinDay(days, id));
    }

    @Override
    public DiscountDto saveNewDiscount(InputDiscountData inputDiscountData) {
        DiscountDto discountDto = new DiscountDto();
        discountDto.setChannel(channelService.findChannelByIdForDiscount(inputDiscountData.getChannelId()));
        discountDto.setEndDate(inputDiscountData.getEndDate());
        discountDto.setStateDate(inputDiscountData.getStarDate());
        discountDto.setMinimumDay(inputDiscountData.getMinimumDay());
        discountDto.setPercent(inputDiscountData.getPercent());
        return DiscountMapper.INSTANCE.toDiscountDto(discountRepo.save(DiscountMapper.INSTANCE.toDiscount(discountDto)));
    }


}
