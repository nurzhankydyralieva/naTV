package kg.megacom.naTV.models.objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InputChannelData {
    private Long channelId;
    @JsonFormat(shape = JsonFormat.Shape.ARRAY, pattern = "dd-MM-yyyy")
    private List<Date> days;
}
