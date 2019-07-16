package art.redoc.service.impl;

import art.redoc.core.conts.RequestCode;
import art.redoc.core.exceptions.CoreRuntimeException;
import art.redoc.model.Goods;
import art.redoc.repository.GoodsRepository;
import art.redoc.service.GoodsService;
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
    public Goods get(@NonNull Long id) {
        final Goods model = goodsRepository.findById(id).orElseThrow(()-> new CoreRuntimeException(RequestCode.USER_NOT_EXISTS, String.format("id为[%s]资源不存在", id)));
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
    public void delete(@NonNull Long id) {
        goodsRepository.deleteById(id);
    }

    @Override
    public void delete(List<Goods> models) {
        goodsRepository.deleteInBatch(models);
    }
}