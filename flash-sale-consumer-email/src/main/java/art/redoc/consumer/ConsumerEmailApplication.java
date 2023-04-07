package art.redoc.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("art.redoc")
public class ConsumerEmailApplication {
    public static void main(final String[] args) {
        SpringApplication.run(ConsumerEmailApplication.class, args);
    }
}
