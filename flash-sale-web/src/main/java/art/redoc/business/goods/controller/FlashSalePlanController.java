package art.redoc.business.goods.controller;

import art.redoc.core.dto.PageResultDTO;
import art.redoc.core.dto.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import art.redoc.business.goods.convertor.FlashSalePlanConvertor;
import art.redoc.business.goods.dto.FlashSalePlanDTO;
import art.redoc.business.goods.model.FlashSalePlan;
import art.redoc.business.goods.service.FlashSalePlanService;

import javax.validation.Valid;

/**
 * FlashSalePlan controller.
 *
 * @author code generator
 */
@Slf4j
@RestController
@RequestMapping("/api/flashSalePlan")
public class FlashSalePlanController {
    @Autowired
    private FlashSalePlanService flashSalePlanService;
    @Autowired
    private FlashSalePlanConvertor flashSalePlanConvertor;

    /**
     * Get model list.
     *
     * @param pageable Paging related params.
     * @return Model list.
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResultDTO<FlashSalePlanDTO> search(final Pageable pageable) {
        final Page<FlashSalePlan> models = this.flashSalePlanService.getAll(pageable);
        return this.flashSalePlanConvertor.toResultDTO(models);
    }

    /**
     * Get detail model by unique ID.
     *
     * @param id Unique ID.
     * @return Detail model.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<FlashSalePlanDTO> get(@PathVariable final Long id) {
        final FlashSalePlan model = this.flashSalePlanService.get(id);
        return this.flashSalePlanConvertor.toResultDTO(model);
    }

    /**
     * Create model.
     *
     * @param flashSalePlanDTO The model DTO.
     * @return DTO of the model that needs to be created.
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<FlashSalePlanDTO> create(@RequestBody @Valid final FlashSalePlanDTO flashSalePlanDTO) {
        final FlashSalePlan model = this.flashSalePlanConvertor.toModel(flashSalePlanDTO);
        this.flashSalePlanService.create(model);
        return this.flashSalePlanConvertor.toResultDTO(model);
    }

    /**
     * Update model.
     *
     * @param id  Unique ID.
     * @param dto DTO of the model that needs to be updated.
     * @return Updated model DTO.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<FlashSalePlanDTO> update(@PathVariable final Long id, @RequestBody @Valid final FlashSalePlanDTO dto) {
        dto.setId(id);
        final FlashSalePlan model = this.flashSalePlanConvertor.toModel(dto);
        this.flashSalePlanService.update(model);
        return this.flashSalePlanConvertor.toResultDTO(model);
    }

    /**
     * Delete model.
     *
     * @param id Unique ID.
     * @return The result of the model being deleted.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> delete(@PathVariable final Long id) {
        this.flashSalePlanService.delete(id);
        return ResultDTO.success();
    }
}