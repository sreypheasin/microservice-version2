package microv2.odin.userservice.api.service;

import microv2.odin.userservice.api.dto.UserRequest;
import microv2.odin.userservice.api.dto.UserResponse;

import java.util.List;

public interface UserService {

     void saveUser(UserRequest userRequest);

     List<UserResponse> getAllUser();

     UserResponse getUserById(String id);

     void deleteUserById(String id);



}
