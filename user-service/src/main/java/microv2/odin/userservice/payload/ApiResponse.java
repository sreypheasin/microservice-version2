package microv2.odin.userservice.payload;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiResponse {

    private String message;
    private Boolean success;
    private HttpStatus status;
}
