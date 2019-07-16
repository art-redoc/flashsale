package art.redoc.base.model;

import art.redoc.api.idgenerator.SnowFlakeGeneratorApi;
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
        try {
            result = SpringUtils.getBeanByType(SnowFlakeGeneratorApi.class).generator();

            if (result.isSuccess()) {
                return result.getData();
            } else {
                // todo 应使用降级策略，使用本地的SnowFlake算法继续生成id
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
