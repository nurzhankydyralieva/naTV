package kg.megacom.naTV.models.objects;

import lombok.Data;

import java.util.List;

@Data
public class OutputChannelData {
    private Long id;
    private String channelName;
    private String photo;
    private double price;
    private List<OutputDiscountData> discounts;
}
