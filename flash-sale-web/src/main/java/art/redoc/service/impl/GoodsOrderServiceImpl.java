package art.redoc.service.impl;

import art.redoc.common.conts.RequestCode;
import art.redoc.core.exceptions.CoreRuntimeException;
import art.redoc.service.GoodsOrderService;
import art.redoc.model.GoodsOrder;
import art.redoc.repository.GoodsOrderRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * GoodsOrderService 实现类
 */
@Slf4j
@Service
public class GoodsOrderServiceImpl implements GoodsOrderService {

    @Autowired
    private GoodsOrderRepository goodsOrderRepository;

    @Override
    @Transactional(readOnly = true)
    public GoodsOrder get(@NonNull Long id) {
        final GoodsOrder model = goodsOrderRepository.findById(id).orElseThrow(()-> new CoreRuntimeException(RequestCode.USER_NOT_EXISTS, String.format("id为[%s]资源不存在", id)));
        return model;
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