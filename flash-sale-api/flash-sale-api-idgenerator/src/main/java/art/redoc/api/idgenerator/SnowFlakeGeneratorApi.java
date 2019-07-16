package art.redoc.api.idgenerator;

import art.redoc.core.dto.ResultDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface SnowFlakeGeneratorApi {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResultDTO<Long> generator() throws Exception;
}
