package kg.megacom.naTV.services;

import kg.megacom.naTV.models.objects.InputOrderData;
import kg.megacom.naTV.models.objects.OrderResponse;

public interface OrderService {
    OrderResponse saveOrder(InputOrderData inputOrderData);
}
