package kg.megacom.naTV.models.entities;

import kg.megacom.naTV.models.entities.Channel;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;
    private double price;
    private Date startDate;
    private Date endDate;

}
