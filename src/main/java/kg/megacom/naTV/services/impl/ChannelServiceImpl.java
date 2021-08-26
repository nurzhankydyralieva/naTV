package kg.megacom.naTV.services.impl;

import kg.megacom.naTV.dao.ChannelRepo;
import kg.megacom.naTV.exceptions.ChannelNotFound;
import kg.megacom.naTV.mappers.ChannelMapper;
import kg.megacom.naTV.models.dto.DiscountDto;
import kg.megacom.naTV.models.dto.PriceDto;
import kg.megacom.naTV.models.entities.Channel;
import kg.megacom.naTV.models.dto.ChannelDto;
import kg.megacom.naTV.models.objects.OutputChannelData;
import kg.megacom.naTV.models.objects.OutputDiscountData;
import kg.megacom.naTV.services.ChannelService;
import kg.megacom.naTV.services.DiscountService;
import kg.megacom.naTV.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Autowired
    private ChannelRepo channelRepository;
    @Autowired
    private PriceService priceService;
    @Autowired
    private DiscountService discountService;
    @Override
    public ChannelDto saveChannel(ChannelDto channelDto) {
        channelDto.setActive(true);
        ChannelDto lastRow = findLastRowNum();
        if (lastRow == null){
            channelDto.setOrderNumber(1);
            Channel channel = channelRepository.save(ChannelMapper.INSTANCE.toChannel(channelDto));
            return ChannelMapper.INSTANCE.toChannelDto(channel);
        }
        channelDto.setOrderNumber(lastRow.getOrderNumber() + 1);
        Channel channel = channelRepository.save(ChannelMapper.INSTANCE.toChannel(channelDto));

        return ChannelMapper.INSTANCE.toChannelDto(channel);
    }



    @Override
    public ChannelDto findChannelByIdForDiscount(Long id) {
        return ChannelMapper.INSTANCE.toChannelDto(channelRepository.findById(id)
                .orElseThrow(() -> new ChannelNotFound("The channel with this id not found.")));
    }

    @Override
    public List<OutputChannelData> outputChannels() {
        List<PriceDto> activeChannelPrice = priceService.allActiveChannelPrices();
        List<PriceDto> activeChFilterById = activeChannelPrice.stream()
                .filter(x -> x.getChannel().isActive()).collect(Collectors.toList());
        List<OutputChannelData> outputChannelDataList = new ArrayList<>();
        for (PriceDto p: activeChFilterById){
            OutputChannelData outputChannelData = new OutputChannelData();
            outputChannelData.setId(p.getId());
            outputChannelData.setChannelName(p.getChannel().getChannelName());
            outputChannelData.setPhoto(p.getChannel().getPhoto());
            outputChannelData.setPrice(p.getPrice());
            List<DiscountDto> channelWithD = discountService.allChannelWithD(p.getChannel().getId());
            List<OutputDiscountData> discountDataList = new ArrayList<>();
            for (DiscountDto d: channelWithD){
                OutputDiscountData outputDiscountData = new OutputDiscountData();
                outputDiscountData.setPercent(d.getPercent());
                outputDiscountData.setMinimumDay(d.getMinimumDay());
                discountDataList.add(outputDiscountData);
            }
            outputChannelData.setDiscounts(discountDataList);
            outputChannelDataList.add(outputChannelData);
        }
        return outputChannelDataList;
    }

    @Override
    public ChannelDto deactivateChannel(Long id) {
        ChannelDto channelDto = findChannelByIdForDiscount(id);
        channelDto.setActive(false);
        return ChannelMapper.INSTANCE.toChannelDto(channelRepository.save(ChannelMapper.INSTANCE.toChannel(channelDto)));
    }

    private ChannelDto findLastRowNum(){
        Channel channel = channelRepository.findRow();
        if (channel == null){
            return null;
        }
        return ChannelMapper.INSTANCE.toChannelDto(channel);
    }
}
