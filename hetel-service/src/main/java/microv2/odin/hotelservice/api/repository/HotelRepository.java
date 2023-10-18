package microv2.odin.hotelservice.api.repository;

import microv2.odin.hotelservice.api.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String > {
}
