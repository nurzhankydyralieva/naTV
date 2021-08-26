package kg.megacom.naTV.models.dto;

import kg.megacom.naTV.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class OrderDto {
    private Long id;
    private String name;
    private String text;
    private String phone;
    private String email;
    private double totalPrice;
    private OrderStatus status;
    private Date addDate;
    private Date editDate;

}
