package microv2.odin.hotelservice.api.service;

import microv2.odin.hotelservice.api.dto.HotelRequest;
import microv2.odin.hotelservice.api.dto.HotelResponse;
import java.util.List;

public interface HotelService {

//    create
     void createUser (HotelRequest hotelRequest);

     List<HotelResponse> getAll ();

     HotelResponse getById (String id);

     void deleteById(String id);

}
