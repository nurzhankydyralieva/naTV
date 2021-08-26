package kg.megacom.naTV.dao;

import kg.megacom.naTV.models.entities.OrderDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDayRepo extends JpaRepository<OrderDay, Long> {
    @Query(value = "select * from order_days od where od.id_order_detail = ?1", nativeQuery = true)
    List<OrderDay> findByOrderDetailId(Long id);
}
