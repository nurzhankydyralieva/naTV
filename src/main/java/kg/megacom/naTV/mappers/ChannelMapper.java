package kg.megacom.naTV.mappers;

import kg.megacom.naTV.models.entities.Channel;
import kg.megacom.naTV.models.dto.ChannelDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ChannelMapper {
    ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);

    Channel toChannel(ChannelDto channelDto);

    ChannelDto toChannelDto(Channel channel);

    List<Channel> toChannels(List<ChannelDto> channelDtos);

    List<ChannelDto> toChannelsDto(List<Channel> channelList);
}
