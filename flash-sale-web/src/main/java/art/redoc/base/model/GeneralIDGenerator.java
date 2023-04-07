package art.redoc.base.model;

import art.redoc.api.idgenerator.SnowFlakeGeneratorApi;
import art.redoc.base.feign.SnowFlakeGeneratorApiFeign;
import art.redoc.common.service.SnowFlakeGeneratorService;
import art.redoc.core.dto.ResultDTO;
import art.redoc.utils.SpringUtils;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * 使用单独的id生成服务，结合SnowFlake算法，生成高效的id
 */
public class GeneralIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        final ResultDTO<Long> result;
        result = SpringUtils.getBeanByType(SnowFlakeGeneratorApi.class).generator();

        if (result.isSuccess()) {
            return result.getData();
        } else {
            return new SnowFlakeGeneratorService().generate(1L, 2L);
        }
    }
}
