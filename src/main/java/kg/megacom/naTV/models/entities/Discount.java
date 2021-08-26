package kg.megacom.naTV.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "discounts")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;
    private double percent;
    private int minimumDay;
    private Date stateDate;
    private Date endDate;
}
