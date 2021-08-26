package kg.megacom.naTV.controllers;

import kg.megacom.naTV.models.dto.ChannelDto;
import kg.megacom.naTV.models.objects.OutputChannelData;
import kg.megacom.naTV.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @PostMapping("/save/channel")
    public ChannelDto save(@RequestBody ChannelDto channelDto) {
        return channelService.saveChannel(channelDto);
    }

    @GetMapping("/all")
    public List<OutputChannelData> outputChannel() {
        return channelService.outputChannels();
    }

    @DeleteMapping("/deactivate/{id}")
    public ChannelDto deactivateChannel(@PathVariable Long id) {
        return channelService.deactivateChannel(id);
    }

}
