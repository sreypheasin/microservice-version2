package microv2.odin.ratingservice.api.repository;

import microv2.odin.ratingservice.api.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    List<Rating> findByUserId (String id);

    List<Rating> findByHotelId (String id);
}
