package mongo.odin.springmongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    private String id;
    private String title;
    private String description;
    private Boolean isPaid;
    private Float rating;
    private String feedback;
}
