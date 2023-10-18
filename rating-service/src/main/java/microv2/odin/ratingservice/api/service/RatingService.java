package microv2.odin.ratingservice.api.service;

import microv2.odin.ratingservice.api.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

//    get all rating
    List<Rating> getRatings();

//    get all rating by userId

    List<Rating> getRatingByUserId(String id);

//    get all rating by hotelId

    List<Rating> getRatingByHotelId(String id);


}
