package microv2.odin.userservice.api.service.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microv2.odin.userservice.api.dto.UserRequest;
import microv2.odin.userservice.api.dto.UserResponse;
import microv2.odin.userservice.api.entity.Hotel;
import microv2.odin.userservice.api.entity.Rating;
import microv2.odin.userservice.api.entity.User;
import microv2.odin.userservice.api.mapstruct.UserMapStruct;
import microv2.odin.userservice.api.repository.UserRepository;
import microv2.odin.userservice.api.service.UserService;
import microv2.odin.userservice.exceptions.ResourceNotFoundException;
import microv2.odin.userservice.external.service.HotelService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapStruct userMapStruct;
    private final RestTemplate restTemplate;
    private final HotelService hotelService;

    @Override
    public void saveUser(UserRequest userRequest) {

        User user = new User();

        user.setName(userRequest.name());
        user.setEmail(userRequest.email());
        user.setAbout(userRequest.about());
        userRepository.save(user);

    }

    @Override
    public List<UserResponse> getAllUser() {

//        implement rating using rest template

        List<User> users = userRepository.findAll();

        return userMapStruct.listOfUserResponseToListOfUser(users);

    }

    @Override
    public UserResponse getUserById(String id) {

        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with the given id not found !!"));

        Rating [] ratingLists = restTemplate.getForObject("http://RATING-SERVICE/api/rating/user/"+user.getId(), Rating [].class);

        List<Rating> ratings = Arrays.stream(ratingLists).toList();

        log.info("Print forObject : {} ", ratings);

        List <Rating> ratingList = ratings.stream().map( rate-> {

//            api call to hotel service to get the hotel
//            ResponseEntity<Hotel> forEntityHotel = restTemplate.getForEntity("http://HOTEL-SERVICE/api/hotel/"+rate.getHotelId(), Hotel.class);

//            Hotel hotel = forEntityHotel.getBody();

//            todo use openfeign
            Hotel hotel = hotelService.getHotel(rate.getHotelId());

//            log.info("Status Code : {}",forEntityHotel.getStatusCode());
//            set the hotel to rating
            rate.setHotel(hotel);

//            return the rating
            return rate;

        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return userMapStruct.userToUserResponse(user);
    }

    @Override
    public void deleteUserById(String id) {

        userRepository.deleteById(id);
    }
}
