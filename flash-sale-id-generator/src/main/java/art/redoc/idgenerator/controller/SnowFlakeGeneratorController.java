package art.redoc.idgenerator.controller;

import art.redoc.api.idgenerator.SnowFlakeGeneratorApi;
import art.redoc.common.service.SnowFlakeGeneratorService;
import art.redoc.core.dto.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SnowFlakeGeneratorController implements SnowFlakeGeneratorApi {

    @Autowired
    private SnowFlakeGeneratorService snowFlakeGeneratorService;


    @Override
    public ResultDTO<Long> generator() {
        return ResultDTO.success(snowFlakeGeneratorService.generate(1L, 1L));
    }

}
