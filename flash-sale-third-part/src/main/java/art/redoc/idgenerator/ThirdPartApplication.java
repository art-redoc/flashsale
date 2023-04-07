package art.redoc.idgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("art.redoc")
@EnableScheduling
public class ThirdPartApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ThirdPartApplication.class, args);
    }
}
