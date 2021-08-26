package kg.megacom.naTV.models.objects;

import lombok.Data;

import java.util.List;

@Data
public class InputOrderData {
    private String addText;
    private String clientName;
    private String clientPhone;
    private String clientEmail;
    private List<InputChannelData> channels;
}
