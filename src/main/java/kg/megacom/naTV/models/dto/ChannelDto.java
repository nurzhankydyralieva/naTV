package kg.megacom.naTV.models.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class ChannelDto {
    private Long id;
    private String channelName;
    private String photo;
    private boolean active;
    private int orderNumber;
}
