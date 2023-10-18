package microv2.odin.userservice.api.repository;

import microv2.odin.userservice.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, String> {

}
