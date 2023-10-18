package microv2.odin.hotelservice.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "hotels")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String location;

    private String About;

}
