package art.redoc.base.feign;

import art.redoc.core.dto.ResultDTO;
import org.springframework.stereotype.Component;

@Component
public class SnowFlakeGeneratorApiFeignFallback implements SnowFlakeGeneratorApiFeign {
    @Override
    public ResultDTO<Long> generator() {
        System.out.println(111);
        // todo 应使用降级策略，使用本地的SnowFlake算法继续生成id
        return null;
    }
}
