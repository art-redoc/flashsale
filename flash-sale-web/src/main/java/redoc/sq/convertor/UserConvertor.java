package redoc.sq.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redoc.sq.base.convertors.AbstractConvertor;
import redoc.sq.dto.UserDTO;
import redoc.sq.model.User;
import redoc.sq.service.UserService;
import lombok.NonNull;

/**
 * UserConvertor
 */
@Component
public class UserConvertor extends AbstractConvertor<User, UserDTO> {

    @Autowired
    private UserService userService;
    
    @Override
    public User toModel(@NonNull final UserDTO dto) {
        if (dto.isNew()) {//新增
            return constructModel(dto);
        } else {//更新
            return updateModel(dto);
        }
    }

    @Override
    public UserDTO toDTO(@NonNull final User model, final boolean forListView) {
        final UserDTO dto = new UserDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        return dto;
    }

    // 构建新Model
    private User constructModel(final UserDTO dto) {
        User model = new User();
        model.setName(dto.getName());

        return model;
    }

    // 更新Model
    private User updateModel(final UserDTO dto) {
        User model = userService.get(dto.getId());
        model.setName(dto.getName());

        return model;
    }
}