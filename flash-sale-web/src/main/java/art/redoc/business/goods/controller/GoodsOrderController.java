package art.redoc.business.goods.controller;

import art.redoc.business.goods.convertor.GoodsOrderConvertor;
import art.redoc.business.goods.model.GoodsOrder;
import art.redoc.business.goods.service.GoodsOrderService;
import art.redoc.core.dto.PageResultDTO;
import art.redoc.core.dto.ResultDTO;
import art.redoc.dto.goods.dto.GoodsOrderDTO;
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
 * GoodsOrder controller.
 *
 * @author code generator
 */
@Slf4j
@RestController
@RequestMapping("/api/goodsOrder")
public class GoodsOrderController {
    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private GoodsOrderConvertor goodsOrderConvertor;

    /**
     * Get model list.
     *
     * @param pageable Paging related params.
     * @return Model list.
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResultDTO<GoodsOrderDTO> search(final Pageable pageable) {
        final Page<GoodsOrder> models = this.goodsOrderService.getAll(pageable);
        return this.goodsOrderConvertor.toResultDTO(models);
    }

    /**
     * Get detail model by unique ID.
     *
     * @param id Unique ID.
     * @return Detail model.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<GoodsOrderDTO> get(@PathVariable final Long id) {
        final GoodsOrder model = this.goodsOrderService.get(id);
        return this.goodsOrderConvertor.toResultDTO(model);
    }

    /**
     * Create model.
     *
     * @param goodsOrderDTO The model DTO.
     * @return DTO of the model that needs to be created.
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<GoodsOrderDTO> create(@RequestBody @Valid final GoodsOrderDTO goodsOrderDTO) {
        final GoodsOrder model = this.goodsOrderConvertor.toModel(goodsOrderDTO);
        this.goodsOrderService.create(model);
        return this.goodsOrderConvertor.toResultDTO(model);
    }

    /**
     * Update model.
     *
     * @param id  Unique ID.
     * @param dto DTO of the model that needs to be updated.
     * @return Updated model DTO.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<GoodsOrderDTO> update(@PathVariable final Long id, @RequestBody @Valid final GoodsOrderDTO dto) {
        dto.setId(id);
        final GoodsOrder model = this.goodsOrderConvertor.toModel(dto);
        this.goodsOrderService.update(model);
        return this.goodsOrderConvertor.toResultDTO(model);
    }

    /**
     * Delete model.
     *
     * @param id Unique ID.
     * @return The result of the model being deleted.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> delete(@PathVariable final Long id) {
        this.goodsOrderService.delete(id);
        return ResultDTO.success();
    }
}