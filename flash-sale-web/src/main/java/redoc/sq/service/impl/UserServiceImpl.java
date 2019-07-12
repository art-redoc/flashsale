package redoc.sq.service.impl;

import redoc.sq.base.conts.RequestCode;
import redoc.sq.base.exceptions.CustomRuntimeException;
import redoc.sq.model.User;
import redoc.sq.repository.UserRepository;
import redoc.sq.service.UserService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserService 实现类
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User get(@NonNull String id) {
        final User model = userRepository.findById(id).orElseThrow(()-> new CustomRuntimeException(RequestCode.USER_NOT_EXISTS, String.format("id为[%s]资源不存在", id)));
        return model;
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
    public void delete(@NonNull String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(List<User> models) {
        userRepository.deleteInBatch(models);
    }
}