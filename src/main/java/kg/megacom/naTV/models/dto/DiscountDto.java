package kg.megacom.naTV.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.megacom.naTV.models.entities.Channel;
import lombok.Data;

import java.util.Date;

@Data
public class DiscountDto {
    private Long id;
    private ChannelDto channel;
    private double percent;
    private int minimumDay;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date stateDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date endDate;
}
