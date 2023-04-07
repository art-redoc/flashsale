package art.redoc.api.web;

import art.redoc.core.dto.ResultDTO;
import art.redoc.dto.goods.dto.RelationUserFlashSalePlanDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

public interface RelationUserFlashSalePlanApi {

    @RequestMapping(value = "/api/relationUserFlashSalePlan", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResultDTO<RelationUserFlashSalePlanDTO> create(@RequestBody @Valid final RelationUserFlashSalePlanDTO relationUserFlashSalePlanDTO);
}
