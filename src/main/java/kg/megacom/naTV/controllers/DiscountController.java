package kg.megacom.naTV.controllers;

import kg.megacom.naTV.models.dto.DiscountDto;
import kg.megacom.naTV.models.objects.InputDiscountData;
import kg.megacom.naTV.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {
    @Autowired
    private DiscountService discountService;
    @PostMapping("/save-discount")
    public DiscountDto saveNewDiscount(@RequestBody InputDiscountData inputDiscountData){
        return discountService.saveNewDiscount(inputDiscountData);
    }
}
