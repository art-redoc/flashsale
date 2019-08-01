package art.redoc.business.goods.service.impl;

import art.redoc.core.conts.CoreResponseCode;
import art.redoc.core.exceptions.CoreRuntimeException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import art.redoc.business.goods.model.Goods;
import art.redoc.business.goods.repository.GoodsRepository;
import art.redoc.business.goods.service.GoodsService;

import java.util.List;

/**
 * Goods service implement.
 *
 * @author code generator
 */
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Goods get(@NonNull Long id) {
        final Goods model = goodsRepository.findById(id).orElseThrow(() ->
                new CoreRuntimeException(CoreResponseCode.RESOURCE_NOT_EXISTS, String.format("The resource with id [%s] does not exist.", id)));
        return model;
    }

    @Override
    public Page<Goods> getAll(Pageable pageable) {
        return this.goodsRepository.findAll(pageable);
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