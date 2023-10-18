package microv2.odin.userservice.api.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microv2.odin.userservice.api.dto.UserRequest;
import microv2.odin.userservice.api.dto.UserResponse;
import microv2.odin.userservice.api.entity.User;
import microv2.odin.userservice.api.mapstruct.UserMapStruct;
import microv2.odin.userservice.api.repository.UserRepository;
import microv2.odin.userservice.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserMapStruct userMapStruct;
    private final UserRepository userRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createUser(@RequestBody UserRequest userRequest){
        userService.saveUser(userRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserResponse> getAllUser(){
       return userService.getAllUser();
    }

    @GetMapping("/{id}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name= "userRetry", fallbackMethod = "userFallback")
//    @RateLimiter(name="userRateLimiter",fallbackMethod = "userRateLimiterFallback")
    public UserResponse getUserById (@PathVariable String id){
        return userService.getUserById(id);
    }

//    create rating fallback method for circuit breaker
//        public UserResponse userRateLimiterFallback(String id, Throwable e){
//                User user = User
//                .builder()
//                .name("Dufin")
//                .email("dufin@gmail.com")
//                .about("This user is created dummy because some service is down (2)")
//                .id(UUID.randomUUID().toString())
//                .build();
////        userRepository.save(user);
//        return userMapStruct.userToUserResponse(user);
//    }

//    private int attempt = 1;
//    public UserResponse userFallback(String id, Throwable e){
//        log.info("Method Retry called : {} times", attempt);
//        attempt++;
//                User user = User
//                .builder()
//                .name("Dufin")
//                .email("dufin@gmail.com")
//                .about("This user is created dummy because some service is down (2)")
//                .id(UUID.randomUUID().toString())
//                .build();
////        userRepository.save(user);
//        return userMapStruct.userToUserResponse(user);
//    }

//    public UserResponse ratingHotelFallback (String id, Exception e){
//        log.info("Fallback is executed because service is down!! {} ", e.getMessage());
//
//        User user = User
//                .builder()
//                .name("Dufin")
//                .email("dufin@gmail.com")
//                .about("This user is created dummy because some service is down (2)")
//                .id(UUID.randomUUID().toString())
//                .build();
////        userRepository.save(user);
//        return userMapStruct.userToUserResponse(user);
//    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable String id){
        userService.deleteUserById(id);
    }
}
