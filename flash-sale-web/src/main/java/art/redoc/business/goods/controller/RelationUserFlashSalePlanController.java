package art.redoc.business.goods.controller;

import art.redoc.api.web.RelationUserFlashSalePlanApi;
import art.redoc.business.goods.convertor.FlashSalePlanConvertor;
import art.redoc.business.goods.convertor.RelationUserFlashSalePlanConvertor;
import art.redoc.business.goods.model.FlashSalePlan;
import art.redoc.business.goods.model.RelationUserFlashSalePlan;
import art.redoc.business.goods.model.User;
import art.redoc.business.goods.service.FlashSalePlanService;
import art.redoc.business.goods.service.RelationUserFlashSalePlanService;
import art.redoc.business.goods.service.UserService;
import art.redoc.core.dto.PageResultDTO;
import art.redoc.core.dto.ResultDTO;
import art.redoc.dto.goods.dto.RelationUserFlashSalePlanDTO;
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

import javax.validation.Valid;

/**
 * Relation user flash sale plan controller.
 *
 * @author code generator
 */
@Slf4j
@RestController
public class RelationUserFlashSalePlanController implements RelationUserFlashSalePlanApi {
    @Autowired
    private RelationUserFlashSalePlanService relationUserFlashSalePlanService;

    @Autowired
    private RelationUserFlashSalePlanConvertor relationUserFlashSalePlanConvertor;
    @Autowired
    private FlashSalePlanService flashSalePlanService;
    @Autowired
    private UserService userService;

    /**
     * Get model list.
     *
     * @param pageable Paging related params.
     * @return Model list.
     */
    @RequestMapping(value = "/api/relationUserFlashSalePlan/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResultDTO<RelationUserFlashSalePlanDTO> search(final Pageable pageable) {
        final Page<RelationUserFlashSalePlan> models = this.relationUserFlashSalePlanService.getAll(pageable);
        return this.relationUserFlashSalePlanConvertor.toResultDTO(models);
    }

    /**
     * Get detail model by unique ID.
     *
     * @param id Unique ID.
     * @return Detail model.
     */
    @RequestMapping(value = "/api/relationUserFlashSalePlan/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<RelationUserFlashSalePlanDTO> get(@PathVariable final Long id) {
        final RelationUserFlashSalePlan model = this.relationUserFlashSalePlanService.get(id);
        return this.relationUserFlashSalePlanConvertor.toResultDTO(model);
    }

    @Override
    public ResultDTO<RelationUserFlashSalePlanDTO> create(@RequestBody @Valid final RelationUserFlashSalePlanDTO relationUserFlashSalePlanDTO) {
        final FlashSalePlan flashSalePlan = flashSalePlanService.get(relationUserFlashSalePlanDTO.getFlashSalePlanId());
        final User user = userService.get(relationUserFlashSalePlanDTO.getUserId());
        RelationUserFlashSalePlan relationUserFlashSalePlan = new RelationUserFlashSalePlan();
        relationUserFlashSalePlan.setFlashSalePlan(flashSalePlan);
        relationUserFlashSalePlan.setUser(user);
        this.relationUserFlashSalePlanService.create(relationUserFlashSalePlan);
        return this.relationUserFlashSalePlanConvertor.toResultDTO(relationUserFlashSalePlan);
    }

    /**
     * Update model.
     *
     * @param id  Unique ID.
     * @param dto DTO of the model that needs to be updated.
     * @return Updated model DTO.
     */
    @RequestMapping(value = "/api/relationUserFlashSalePlan/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<RelationUserFlashSalePlanDTO> update(@PathVariable final Long id, @RequestBody @Valid final RelationUserFlashSalePlanDTO dto) {
        dto.setId(id);
        final RelationUserFlashSalePlan model = this.relationUserFlashSalePlanConvertor.toModel(dto);
        this.relationUserFlashSalePlanService.update(model);
        return this.relationUserFlashSalePlanConvertor.toResultDTO(model);
    }

    /**
     * Delete model.
     *
     * @param id Unique ID.
     * @return The result of the model being deleted.
     */
    @RequestMapping(value = "/api/relationUserFlashSalePlan/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> delete(@PathVariable final Long id) {
        this.relationUserFlashSalePlanService.delete(id);
        return ResultDTO.success();
    }
}
