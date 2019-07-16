package art.redoc.idgenerator.controller;

import art.redoc.api.idgenerator.SnowFlakeGeneratorRequestMappingApi;
import art.redoc.common.service.SnowFlakeGeneratorService;
import art.redoc.core.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SnowFlakeGeneratorController implements SnowFlakeGeneratorRequestMappingApi {

    @Autowired
    private SnowFlakeGeneratorService snowFlakeGeneratorService;

    @Override
    public ResultDTO<Long> generator() throws Exception {
        throw new Exception();
//        return ResultDTO.success(snowFlakeGeneratorService.generate());
    }
}
