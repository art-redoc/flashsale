//package art.redoc.idgenerator.controller;
//
//import art.redoc.common.service.SnowFlakeGeneratorService;
//import io.micrometer.core.instrument.Counter;
//import io.micrometer.core.instrument.MeterRegistry;
//import org.apache.commons.lang3.RandomUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Configuration
//public class PrometheusController {
//
//    @Autowired
//    MeterRegistry registry;
//    @Autowired
//    SnowFlakeGeneratorController snowFlakeGeneratorController;
//
//    @Autowired
//    private SnowFlakeGeneratorService snowFlakeGeneratorService;
//
//    @Bean
//    public Counter getCounter() {
//        return registry.counter("redoc_total", "v1", "core");
//    }
//
//
////    @Scheduled(cron = "0/15 * * * * ?")
//    public void gauge() {
////        registry.gauge("redoc_gauge", new AtomicInteger(0)).set(RandomUtils.nextInt(1, 10000));
//        snowFlakeGeneratorController.handleMetrics();
//    }
//
//    @Bean
//    MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName) {
//        return registry -> registry.config().commonTags("application", applicationName);
//    }
//
//    enum A{
//        Q,W
//    }
//
//    public static void main(String[] args) {
//        System.out.println("ashjhjasjhjhhjhasjhjhjhjasjhjhjhjasjhjhjqwe123".replace("as","$$$"));
//        String s = "ashjhjasjhjhhjhasjhjhjhjasjhjhjhjasjhjhjqwe123";
//        System.out.println(s.substring(0,s.length() -1 ));
//        System.out.println(A.valueOf("C"));
//    }
//}
