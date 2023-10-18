package microv2.odin.ratingservice.api.controller;

import lombok.RequiredArgsConstructor;
import microv2.odin.ratingservice.api.entity.Rating;
import microv2.odin.ratingservice.api.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/rating")
public class RatingController {

    private final RatingService ratingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Rating create (@RequestBody Rating rating){

        return ratingService.create(rating);
    }

//  get all rating
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Rating> getAll(){

        return ratingService.getRatings();
    }

//    get rating by user id
    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Rating> getRatingByUserId(@PathVariable String userId){
        return ratingService.getRatingByUserId(userId);
    }

//    get rating by hotel id
    @GetMapping("/hotel/{hotelId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Rating> getRatingByHotelId (@PathVariable String hotelId){
        return ratingService.getRatingByHotelId(hotelId);
    }
}
