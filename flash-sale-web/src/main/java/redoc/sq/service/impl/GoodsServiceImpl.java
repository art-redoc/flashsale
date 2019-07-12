package redoc.sq.service.impl;

import redoc.sq.base.conts.RequestCode;
import redoc.sq.base.exceptions.CustomRuntimeException;
import redoc.sq.model.Goods;
import redoc.sq.repository.GoodsRepository;
import redoc.sq.service.GoodsService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * GoodsService 实现类
 */
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    @Transactional(readOnly = true)
    public Goods get(@NonNull String id) {
        final Goods model = goodsRepository.findById(id).orElseThrow(()-> new CustomRuntimeException(RequestCode.USER_NOT_EXISTS, String.format("id为[%s]资源不存在", id)));
        return model;
    }

    @Override
    public Goods create(Goods model) {
        return goodsRepository.save(model);
    }

    @Override
    public List<Goods> create(List<Goods> models) {
        return goodsRepository.saveAll(models);
    }

    @Override
    public Goods update(Goods model) {
        return goodsRepository.save(model);
    }

    @Override
    public void delete(@NonNull String id) {
        goodsRepository.deleteById(id);
    }

    @Override
    public void delete(List<Goods> models) {
        goodsRepository.deleteInBatch(models);
    }
}