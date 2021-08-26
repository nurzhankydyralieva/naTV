package kg.megacom.naTV.dao;

import kg.megacom.naTV.models.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {
    @Query(value = "SELECT * FROM price WHERE CURRENT_TIMESTAMP BETWEEN start_date AND end_date" , nativeQuery = true)
    List<Price> allActiveChannelPrices();


    @Query(value = "select * from prices p where p.channel_id = ?1 and current_timestamp between start_date and end_date", nativeQuery = true)
    Price findChannelDate(Long channelId);
}
