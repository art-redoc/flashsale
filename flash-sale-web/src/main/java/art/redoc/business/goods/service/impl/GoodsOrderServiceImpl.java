package art.redoc.business.goods.service.impl;

import art.redoc.core.conts.CoreResponseCode;
import art.redoc.core.exceptions.CoreRuntimeException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import art.redoc.business.goods.model.GoodsOrder;
import art.redoc.business.goods.repository.GoodsOrderRepository;
import art.redoc.business.goods.service.GoodsOrderService;

import java.util.List;

/**
 * GoodsOrder service implement.
 *
 * @author code generator
 */
@Slf4j
@Service
public class GoodsOrderServiceImpl implements GoodsOrderService {

    @Autowired
    private GoodsOrderRepository goodsOrderRepository;

    @Override
    public GoodsOrder get(@NonNull Long id) {
        final GoodsOrder model = goodsOrderRepository.findById(id).orElseThrow(() ->
                new CoreRuntimeException(CoreResponseCode.RESOURCE_NOT_EXISTS, String.format("The resource with id [%s] does not exist.", id)));
        return model;
    }

    @Override
    public Page<GoodsOrder> getAll(Pageable pageable) {
        return this.goodsOrderRepository.findAll(pageable);
    }

    @Override
    public GoodsOrder create(GoodsOrder model) {
        return goodsOrderRepository.save(model);
    }

    @Override
    public List<GoodsOrder> create(List<GoodsOrder> models) {
        return goodsOrderRepository.saveAll(models);
    }

    @Override
    public GoodsOrder update(GoodsOrder model) {
        return goodsOrderRepository.save(model);
    }

    @Override
    public void delete(@NonNull Long id) {
        goodsOrderRepository.deleteById(id);
    }

    @Override
    public void delete(List<GoodsOrder> models) {
        goodsOrderRepository.deleteInBatch(models);
    }
}