package art.redoc.consumer.base.feign;

import art.redoc.api.idgenerator.SnowFlakeGeneratorApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "idgenerator-service", fallback = SnowFlakeGeneratorApiFeignFallback.class)
public interface SnowFlakeGeneratorApiFeign extends SnowFlakeGeneratorApi {
}
