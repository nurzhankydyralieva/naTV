package kg.megacom.naTV.services;

import kg.megacom.naTV.models.dto.ChannelDto;
import kg.megacom.naTV.models.objects.OutputChannelData;

import java.util.List;

public interface ChannelService {
    ChannelDto saveChannel(ChannelDto channelDto);

    ChannelDto findChannelByIdForDiscount(Long id);

    List<OutputChannelData> outputChannels();

    ChannelDto deactivateChannel(Long id);

}
