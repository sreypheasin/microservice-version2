package microv2.odin.hotelservice.api.controller;

import lombok.RequiredArgsConstructor;
import microv2.odin.hotelservice.api.dto.HotelRequest;
import microv2.odin.hotelservice.api.dto.HotelResponse;
import microv2.odin.hotelservice.api.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createHotel (@RequestBody HotelRequest hotelRequest){
        hotelService.createUser(hotelRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HotelResponse> getAll(){
        return hotelService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HotelResponse getById (@PathVariable String id){
        return hotelService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById (@PathVariable String id){

         hotelService.deleteById(id);
    }

}

