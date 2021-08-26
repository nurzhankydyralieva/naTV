package kg.megacom.naTV.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "channels")
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String channelName;
    @Column(length = 100000)
    private String photo;
    private boolean active;
    private int orderNumber;
}
