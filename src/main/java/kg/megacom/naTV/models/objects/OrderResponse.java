package kg.megacom.naTV.models.objects;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private Long paymentCode;
    private double orderCost;
    private String addText;
    private List<ChannelOrderData> channels;
}
