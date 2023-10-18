package microv2.odin.ratingservice.api.service.implement;

import lombok.RequiredArgsConstructor;
import microv2.odin.ratingservice.api.entity.Rating;
import microv2.odin.ratingservice.api.repository.RatingRepository;
import microv2.odin.ratingservice.api.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingImpl implements RatingService {

    private final RatingRepository ratingRepository;

    @Override
    public Rating create (Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String id) {
        return ratingRepository.findByUserId(id);
    }

    @Override
    public List<Rating> getRatingByHotelId(String id) {
        return ratingRepository.findByHotelId(id);
    }
}
