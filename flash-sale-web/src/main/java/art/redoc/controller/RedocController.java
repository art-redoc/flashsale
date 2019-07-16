package art.redoc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedocController {

    @GetMapping("/")
    public Long get() throws Exception {
        return 1L;
//        return snowFlakeGeneratorApiFeign.generator().getData();
    }
}
