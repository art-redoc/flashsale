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
import redoc.sq.convertor.GoodsConvertor;
import redoc.sq.dto.GoodsDTO;
import redoc.sq.model.Goods;
import redoc.sq.service.GoodsService;
import redoc.sq.repository.GoodsRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Goods的管理接口
 *
 * @author auto
 */
@Slf4j
@RestController
@RequestMapping("/api/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsConvertor goodsConvertor;
    @Autowired
    private GoodsRepository goodsRepository;

    /**
     * 获取分页数据
     *
     * @param pageable 分页+排序参数
     * @return 分页数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResultDTO<GoodsDTO> search(final Pageable pageable) {
        final Page<Goods> models = this.goodsRepository.findAll(pageable);
        return this.goodsConvertor.toResultDTO(models);
    }

    /**
     * 取得详细数据
     *
     * @param id 资源ID
     * @return 资源详细
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<GoodsDTO> get(@PathVariable final String id) {
        final Goods model = this.goodsService.get(id);
        return this.goodsConvertor.toResultDTO(model);
    }

    /**
     * 新建操作
     *
     * @param goodsDTO 新建资源的DTO
     * @return 新建资源
     */
    @RequestMapping(method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<GoodsDTO> create(@RequestBody @Valid final GoodsDTO goodsDTO) {
        final Goods model = this.goodsConvertor.toModel(goodsDTO);
        this.goodsService.create(model);
        return this.goodsConvertor.toResultDTO(model);
    }
    
    /**
     * 更新操作
     *
     * @param id 更新资源的ID
     * @param goodsDTO 更新资源的DTO
     * @return 更新后资源
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<GoodsDTO> update(@PathVariable final String id, @RequestBody @Valid final GoodsDTO goodsDTO) {
        goodsDTO.setId(id);
        final Goods model = this.goodsConvertor.toModel(goodsDTO);
        this.goodsService.update(model);
        return this.goodsConvertor.toResultDTO(model);
    }

    /**
     * 删除操作
     *
     * @param id 资源ID
     * @return 操作结果
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> delete(@PathVariable final String id) {
        this.goodsService.delete(id);
        return ResultDTO.success();
    }
}