package art.redoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@EnableHystrixDashboard
@EnableHystrix
@ComponentScan("art.redoc")
public class WebApplication {
    public static void main(final String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
