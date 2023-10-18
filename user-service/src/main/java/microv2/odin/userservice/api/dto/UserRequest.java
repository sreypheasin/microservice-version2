package microv2.odin.userservice.api.dto;

import lombok.Builder;

@Builder
public record UserRequest (
        String name,
        String email,
        String about
){
}
