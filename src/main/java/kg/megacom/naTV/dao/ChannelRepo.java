package kg.megacom.naTV.dao;

import kg.megacom.naTV.models.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepo extends JpaRepository<Channel, Long> {
@Query(value = "SELECT * FROM channels WHERE id = (SELECT max(id) FROM channels)", nativeQuery = true)
    Channel findRow();
}
