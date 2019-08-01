package art.redoc.business.test.service.impl;

import art.redoc.core.conts.CoreResponseCode;
import art.redoc.core.exceptions.CoreRuntimeException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import art.redoc.business.test.model.Test;
import art.redoc.business.test.repository.TestRepository;
import art.redoc.business.test.service.TestService;

import java.util.List;

/**
 * Test service implement.
 *
 * @author code generator
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public Test get(@NonNull Long id) {
        final Test model = testRepository.findById(id).orElseThrow(() ->
                new CoreRuntimeException(CoreResponseCode.RESOURCE_NOT_EXISTS, String.format("The resource with id [%s] does not exist.", id)));
        return model;
    }

    @Override
    public Page<Test> getAll(Pageable pageable) {
        return this.testRepository.findAll(pageable);
    }

    @Override
    public Test create(Test model) {
        return testRepository.save(model);
    }

    @Override
    public List<Test> create(List<Test> models) {
        return testRepository.saveAll(models);
    }

    @Override
    public Test update(Test model) {
        return testRepository.save(model);
    }

    @Override
    public void delete(@NonNull Long id) {
        testRepository.deleteById(id);
    }

    @Override
    public void delete(List<Test> models) {
        testRepository.deleteInBatch(models);
    }
}