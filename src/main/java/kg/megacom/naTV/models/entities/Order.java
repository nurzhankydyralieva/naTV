package kg.megacom.naTV.models.entities;

import kg.megacom.naTV.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String text;
    private String phone;
    private String email;
    private double totalPrice;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Date addDate;
    private Date editDate;
}
