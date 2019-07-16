package art.redoc.base.feign;

        import art.redoc.api.idgenerator.SnowFlakeGeneratorApi;
        import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "idgenerator-service", fallback = SnowFlakeGeneratorApiFeignFallback.class)
public interface SnowFlakeGeneratorApiFeign extends SnowFlakeGeneratorApi {
}
