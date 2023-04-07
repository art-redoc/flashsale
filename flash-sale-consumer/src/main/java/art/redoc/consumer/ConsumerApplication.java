package art.redoc.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("art.redoc")
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class ConsumerApplication {
    public static void main(final String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
