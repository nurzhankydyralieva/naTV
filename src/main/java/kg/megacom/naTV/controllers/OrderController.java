package kg.megacom.naTV.controllers;

import kg.megacom.naTV.models.objects.InputOrderData;
import kg.megacom.naTV.models.objects.OrderResponse;
import kg.megacom.naTV.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/save-order")
    public OrderResponse saveOrder(@RequestBody InputOrderData inputOrderData){
        return orderService.saveOrder(inputOrderData);
    }
}
