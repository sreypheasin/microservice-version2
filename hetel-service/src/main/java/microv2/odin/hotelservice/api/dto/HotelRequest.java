package microv2.odin.hotelservice.api.dto;

public record HotelRequest (
        String name,
        String location,
        String about
) {
}
