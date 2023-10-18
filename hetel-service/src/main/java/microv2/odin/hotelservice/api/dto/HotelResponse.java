package microv2.odin.hotelservice.api.dto;

import lombok.Builder;

@Builder
public record HotelResponse (
        String id,
        String name,
        String location,
        String about
) {

}
