package microv2.odin.hotelservice.api.mapstruct;

import microv2.odin.hotelservice.api.dto.HotelResponse;
import microv2.odin.hotelservice.api.entity.Hotel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotelMapStruct {

    List<HotelResponse> listOfHotelToListOfHotelResponse (List<Hotel> model);

    HotelResponse hotelToHotelResponse (Hotel model);
}
