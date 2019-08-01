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

import art.redoc.business.goods.convertor.GoodsConvertor;
import art.redoc.business.goods.dto.GoodsDTO;
import art.redoc.business.goods.model.Goods;
import art.redoc.business.goods.service.GoodsService;

import javax.validation.Valid;

/**
 * Goods controller.
 *
 * @author code generator
 */
@Slf4j
@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsConvertor goodsConvertor;

    /**
     * Get model list.
     *
     * @param pageable Paging related params.
     * @return Model list.
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResultDTO<GoodsDTO> search(final Pageable pageable) {
        final Page<Goods> models = this.goodsService.getAll(pageable);
        return this.goodsConvertor.toResultDTO(models);
    }

    /**
     * Get detail model by unique ID.
     *
     * @param id Unique ID.
     * @return Detail model.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<GoodsDTO> get(@PathVariable final Long id) {
        final Goods model = this.goodsService.get(id);
        return this.goodsConvertor.toResultDTO(model);
    }

    /**
     * Create model.
     *
     * @param goodsDTO The model DTO.
     * @return DTO of the model that needs to be created.
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<GoodsDTO> create(@RequestBody @Valid final GoodsDTO goodsDTO) {
        final Goods model = this.goodsConvertor.toModel(goodsDTO);
        this.goodsService.create(model);
        return this.goodsConvertor.toResultDTO(model);
    }

    /**
     * Update model.
     *
     * @param id  Unique ID.
     * @param dto DTO of the model that needs to be updated.
     * @return Updated model DTO.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<GoodsDTO> update(@PathVariable final Long id, @RequestBody @Valid final GoodsDTO dto) {
        dto.setId(id);
        final Goods model = this.goodsConvertor.toModel(dto);
        this.goodsService.update(model);
        return this.goodsConvertor.toResultDTO(model);
    }

    /**
     * Delete model.
     *
     * @param id Unique ID.
     * @return The result of the model being deleted.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> delete(@PathVariable final Long id) {
        this.goodsService.delete(id);
        return ResultDTO.success();
    }
}