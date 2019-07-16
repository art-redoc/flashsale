package art.redoc.controller;

import art.redoc.convertor.GoodsOrderConvertor;
import art.redoc.service.GoodsOrderService;
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
import art.redoc.core.dto.PageResultDTO;
import art.redoc.core.dto.ResultDTO;
import art.redoc.dto.GoodsOrderDTO;
import art.redoc.model.GoodsOrder;
import art.redoc.repository.GoodsOrderRepository;

import javax.validation.Valid;

/**
 * GoodsOrder的管理接口
 *
 * @author auto
 */
@Slf4j
@RestController
@RequestMapping("/api/goodsOrder")
public class GoodsOrderController {
    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private GoodsOrderConvertor goodsOrderConvertor;
    @Autowired
    private GoodsOrderRepository goodsOrderRepository;

    /**
     * 获取分页数据
     *
     * @param pageable 分页+排序参数
     * @return 分页数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResultDTO<GoodsOrderDTO> search(final Pageable pageable) {
        final Page<GoodsOrder> models = this.goodsOrderRepository.findAll(pageable);
        return this.goodsOrderConvertor.toResultDTO(models);
    }

    /**
     * 取得详细数据
     *
     * @param id 资源ID
     * @return 资源详细
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<GoodsOrderDTO> get(@PathVariable final Long id) {
        final GoodsOrder model = this.goodsOrderService.get(id);
        return this.goodsOrderConvertor.toResultDTO(model);
    }

    /**
     * 新建操作
     *
     * @param goodsOrderDTO 新建资源的DTO
     * @return 新建资源
     */
    @RequestMapping(method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<GoodsOrderDTO> create(@RequestBody @Valid final GoodsOrderDTO goodsOrderDTO) {
        final GoodsOrder model = this.goodsOrderConvertor.toModel(goodsOrderDTO);
        this.goodsOrderService.create(model);
        return this.goodsOrderConvertor.toResultDTO(model);
    }
    
    /**
     * 更新操作
     *
     * @param id 更新资源的ID
     * @param goodsOrderDTO 更新资源的DTO
     * @return 更新后资源
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<GoodsOrderDTO> update(@PathVariable final Long id, @RequestBody @Valid final GoodsOrderDTO goodsOrderDTO) {
        goodsOrderDTO.setId(id);
        final GoodsOrder model = this.goodsOrderConvertor.toModel(goodsOrderDTO);
        this.goodsOrderService.update(model);
        return this.goodsOrderConvertor.toResultDTO(model);
    }

    /**
     * 删除操作
     *
     * @param id 资源ID
     * @return 操作结果
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> delete(@PathVariable final Long id) {
        this.goodsOrderService.delete(id);
        return ResultDTO.success();
    }
}