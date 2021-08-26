package kg.megacom.naTV.controllers;

import kg.megacom.naTV.models.dto.PriceDto;
import kg.megacom.naTV.models.objects.InputPriceData;
import kg.megacom.naTV.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api//v1/price")
public class PriceController {
    @Autowired
    private PriceService priceService;
    @PostMapping("save-price")
    public PriceDto savePrice(@RequestBody InputPriceData inputPriceData){
        return priceService.savePrice(inputPriceData);
    }
}
