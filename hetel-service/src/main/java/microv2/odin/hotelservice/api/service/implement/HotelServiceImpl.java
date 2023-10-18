package microv2.odin.hotelservice.api.service.implement;

import lombok.RequiredArgsConstructor;
import microv2.odin.hotelservice.api.dto.HotelRequest;
import microv2.odin.hotelservice.api.dto.HotelResponse;
import microv2.odin.hotelservice.api.entity.Hotel;
import microv2.odin.hotelservice.api.mapstruct.HotelMapStruct;
import microv2.odin.hotelservice.api.repository.HotelRepository;
import microv2.odin.hotelservice.api.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapStruct hotelMapStruct;
    @Override
    public void createUser(HotelRequest hotelRequest) {

        Hotel hotel = new Hotel();

        hotel.setName(hotelRequest.name());
        hotel.setLocation(hotelRequest.location());
        hotel.setAbout(hotelRequest.about());

        hotelRepository.save(hotel);
    }

    @Override
    public List<HotelResponse> getAll() {

        List<Hotel> hotels = hotelRepository.findAll();

        return hotelMapStruct.listOfHotelToListOfHotelResponse(hotels);
    }

    @Override
    public HotelResponse getById(String id) {

        Hotel hotel = hotelRepository.findById(id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.format("User with id %s not found !!", id)));

        return hotelMapStruct.hotelToHotelResponse(hotel);
    }

    @Override
    public void deleteById(String id) {
        hotelRepository.deleteById(id);
    }
}
