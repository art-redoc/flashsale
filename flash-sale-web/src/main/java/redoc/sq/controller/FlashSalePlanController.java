package redoc.sq.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import redoc.sq.base.dto.PageResultDTO;
import redoc.sq.base.dto.ResultDTO;
import redoc.sq.convertor.FlashSalePlanConvertor;
import redoc.sq.dto.FlashSalePlanDTO;
import redoc.sq.model.FlashSalePlan;
import redoc.sq.service.FlashSalePlanService;
import redoc.sq.repository.FlashSalePlanRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * FlashSalePlan的管理接口
 *
 * @author auto
 */
@Slf4j
@RestController
@RequestMapping("/api/flashSalePlan")
public class FlashSalePlanController {
    @Autowired
    private FlashSalePlanService flashSalePlanService;
    @Autowired
    private FlashSalePlanConvertor flashSalePlanConvertor;
    @Autowired
    private FlashSalePlanRepository flashSalePlanRepository;

    /**
     * 获取分页数据
     *
     * @param pageable 分页+排序参数
     * @return 分页数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResultDTO<FlashSalePlanDTO> search(final Pageable pageable) {
        final Page<FlashSalePlan> models = this.flashSalePlanRepository.findAll(pageable);
        return this.flashSalePlanConvertor.toResultDTO(models);
    }

    /**
     * 取得详细数据
     *
     * @param id 资源ID
     * @return 资源详细
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<FlashSalePlanDTO> get(@PathVariable final String id) {
        final FlashSalePlan model = this.flashSalePlanService.get(id);
        return this.flashSalePlanConvertor.toResultDTO(model);
    }

    /**
     * 新建操作
     *
     * @param flashSalePlanDTO 新建资源的DTO
     * @return 新建资源
     */
    @RequestMapping(method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<FlashSalePlanDTO> create(@RequestBody @Valid final FlashSalePlanDTO flashSalePlanDTO) {
        final FlashSalePlan model = this.flashSalePlanConvertor.toModel(flashSalePlanDTO);
        this.flashSalePlanService.create(model);
        return this.flashSalePlanConvertor.toResultDTO(model);
    }
    
    /**
     * 更新操作
     *
     * @param id 更新资源的ID
     * @param flashSalePlanDTO 更新资源的DTO
     * @return 更新后资源
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<FlashSalePlanDTO> update(@PathVariable final String id, @RequestBody @Valid final FlashSalePlanDTO flashSalePlanDTO) {
        flashSalePlanDTO.setId(id);
        final FlashSalePlan model = this.flashSalePlanConvertor.toModel(flashSalePlanDTO);
        this.flashSalePlanService.update(model);
        return this.flashSalePlanConvertor.toResultDTO(model);
    }

    /**
     * 删除操作
     *
     * @param id 资源ID
     * @return 操作结果
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> delete(@PathVariable final String id) {
        this.flashSalePlanService.delete(id);
        return ResultDTO.success();
    }
}