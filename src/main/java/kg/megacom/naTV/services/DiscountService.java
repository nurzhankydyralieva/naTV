package kg.megacom.naTV.services;

import kg.megacom.naTV.models.dto.DiscountDto;
import kg.megacom.naTV.models.objects.InputDiscountData;
import kg.megacom.naTV.models.objects.InputOrderData;

import java.util.List;

public interface DiscountService {
    List<DiscountDto> allChannelWithD(Long id);
    DiscountDto findChannelAndMinDay(int days, Long id);
    DiscountDto saveNewDiscount(InputDiscountData inputDiscountData);
}
