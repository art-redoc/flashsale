package art.redoc.business.goods.service.impl;

import art.redoc.core.conts.CoreResponseCode;
import art.redoc.core.exceptions.CoreRuntimeException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import art.redoc.business.goods.model.User;
import art.redoc.business.goods.repository.UserRepository;
import art.redoc.business.goods.service.UserService;

import java.util.List;

/**
 * User service implement.
 *
 * @author code generator
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User get(@NonNull Long id) {
        final User model = userRepository.findById(id).orElseThrow(() ->
                new CoreRuntimeException(CoreResponseCode.RESOURCE_NOT_EXISTS,
                        String.format("The resource with id [%s] does not exist.", id)));
        return model;
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public User create(User model) {
        return userRepository.save(model);
    }

    @Override
    public List<User> create(List<User> models) {
        return userRepository.saveAll(models);
    }

    @Override
    public User update(User model) {
        return userRepository.save(model);
    }

    @Override
    public void delete(@NonNull Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(List<User> models) {
        userRepository.deleteInBatch(models);
    }
}
