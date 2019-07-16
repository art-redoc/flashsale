package art.redoc.idgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("art.redoc")
public class IDGeneratorApplication {
    public static void main(final String[] args) {
        SpringApplication.run(IDGeneratorApplication.class, args);
    }
}
