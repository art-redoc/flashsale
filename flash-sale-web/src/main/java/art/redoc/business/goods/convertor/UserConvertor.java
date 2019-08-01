package art.redoc.business.goods.convertor;

import art.redoc.core.convertors.AbstractConvertor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import art.redoc.business.goods.dto.UserDTO;
import art.redoc.business.goods.model.User;
import art.redoc.business.goods.service.UserService;

/**
 * User convertor.
 *
 * @author code generator
 */
@Component
public class UserConvertor extends AbstractConvertor<User, UserDTO> {

    @Autowired
    private UserService userService;

    @Override
    public User toModel(@NonNull final UserDTO dto) {
        if (dto.isNew()) {
            return constructModel(dto);
        } else {
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

    /**
     * Build the new model by DTO.
     *
     * @param dto DTO.
     * @return The newly built model.
     */
    private User constructModel(final UserDTO dto) {
        User model = new User();
        model.setName(dto.getName());

        return model;
    }

    /**
     * Update the model by DTO.
     *
     * @param dto DTO.
     * @return The updated model.
     */
    private User updateModel(final UserDTO dto) {
        User model = userService.get(dto.getId());
        model.setName(dto.getName());

        return model;
    }
}