package microv2.odin.userservice.external.service;


import microv2.odin.userservice.api.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/api/hotel/{hotelId}")
    Hotel getHotel (@PathVariable("hotelId") String hotelId);
}
