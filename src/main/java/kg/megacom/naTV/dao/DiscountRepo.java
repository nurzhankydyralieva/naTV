package kg.megacom.naTV.dao;

import kg.megacom.naTV.models.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long> {
    @Query(value = "SELECT * FROM discounts ds WHERE ds.channel_id = ?1 AND CURRENT_TIMESTAMP BETWEEN start_date AND end_date order by minimum_day asc", nativeQuery = true)
    List<Discount> allActiveChannelD(Long id);

    @Query(value = "select * from discounts d where d.minimumDay = (select MAX(minimumDay) from discounts d where d.minimumDay <= ?1) and current_timestamp between start_date and end_date and d.channel_id = ?2", nativeQuery = true)
    Discount findChannelAndMinDay(int days, Long id);
}
