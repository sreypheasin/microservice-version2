package mongo.odin.springmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMongoApplication implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        courseRepository.deleteAll();

//      insert
        Course course = Course.builder()
                .title("Spring")
                .description("CSTAD spring")
                .isPaid(true)
                .rating(1000f)
                .feedback("it's good")
                .build();
        Course course1 = Course.builder()
                .title("Database")
                .description("CSTAD spring")
                .isPaid(true)
                .rating(1000f)
                .feedback("it's good")
                .build();
        Course course2 = Course.builder()
                .title("DevOps")
                .description("CSTAD spring")
                .isPaid(true)
                .rating(1000f)
                .feedback("it's good")
                .build();

        courseRepository.save(course);
        courseRepository.save(course1);
        courseRepository.save(course2);

        courseRepository.findAll();

    }
}
