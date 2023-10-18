package microv2.odin.userservice.api.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;
import microv2.odin.userservice.api.entity.Rating;

import java.util.ArrayList;
import java.util.List;

@Builder
public record UserResponse(
        String id,
        String name,
        String email,
        String about,

        List<Rating> ratings
) {
}
