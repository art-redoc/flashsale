package art.redoc.consumer.base.feign;

import art.redoc.common.service.SnowFlakeGeneratorService;
import art.redoc.core.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SnowFlakeGeneratorApiFeignFallback implements SnowFlakeGeneratorApiFeign {

    @Autowired
    private SnowFlakeGeneratorService snowFlakeGeneratorService;

    @Override
    public ResultDTO<Long> generator() {
        return ResultDTO.success(snowFlakeGeneratorService.generate(1L, 2L));
    }
}
