package art.redoc.controller;

import art.redoc.base.feign.SnowFlakeGeneratorApiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedocController {

    @Autowired
    private SnowFlakeGeneratorApiFeign snowFlakeGeneratorApiFeign;

    @GetMapping("/")
    public Long get() throws Exception {
        return snowFlakeGeneratorApiFeign.generator().getData();
    }
}
