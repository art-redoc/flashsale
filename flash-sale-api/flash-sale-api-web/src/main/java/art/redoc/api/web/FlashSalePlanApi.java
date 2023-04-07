package art.redoc.api.web;

import art.redoc.core.dto.ResultDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface FlashSalePlanApi {

    @RequestMapping(value = "/api/flashSalePlan", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResultDTO<Void> updateFlashSalePlanStatusAndAmount(@RequestParam(name = "id") final Long id);
}
