package kg.megacom.naTV.models.entities;

import kg.megacom.naTV.models.entities.Channel;
import kg.megacom.naTV.models.entities.Order;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private double price;
}
