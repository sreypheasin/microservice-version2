package microv2.odin.userservice.api.mapstruct;

import microv2.odin.userservice.api.dto.UserRequest;
import microv2.odin.userservice.api.dto.UserResponse;
import microv2.odin.userservice.api.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapStruct {

    List<UserResponse> listOfUserResponseToListOfUser (List<User> model);

    UserResponse userToUserResponse (User model);

    UserRequest userToUserRequest (User model);



    UserResponse userRequestToUserResponse (UserResponse model);
}
