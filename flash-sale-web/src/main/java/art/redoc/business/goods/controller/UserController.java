package art.redoc.business.goods.controller;

import art.redoc.core.dto.PageResultDTO;
import art.redoc.core.dto.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import art.redoc.business.goods.convertor.UserConvertor;
import art.redoc.business.goods.dto.UserDTO;
import art.redoc.business.goods.model.User;
import art.redoc.business.goods.service.UserService;

import javax.validation.Valid;

/**
 * User controller.
 *
 * @author code generator
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserConvertor userConvertor;

    /**
     * Get model list.
     *
     * @param pageable Paging related params.
     * @return Model list.
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResultDTO<UserDTO> search(final Pageable pageable) {
        final Page<User> models = this.userService.getAll(pageable);
        return this.userConvertor.toResultDTO(models);
    }

    /**
     * Get detail model by unique ID.
     *
     * @param id Unique ID.
     * @return Detail model.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<UserDTO> get(@PathVariable final Long id) {
        final User model = this.userService.get(id);
        return this.userConvertor.toResultDTO(model);
    }

    /**
     * Create model.
     *
     * @param userDTO The model DTO.
     * @return DTO of the model that needs to be created.
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<UserDTO> create(@RequestBody @Valid final UserDTO userDTO) {
        final User model = this.userConvertor.toModel(userDTO);
        this.userService.create(model);
        return this.userConvertor.toResultDTO(model);
    }

    /**
     * Update model.
     *
     * @param id  Unique ID.
     * @param dto DTO of the model that needs to be updated.
     * @return Updated model DTO.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<UserDTO> update(@PathVariable final Long id, @RequestBody @Valid final UserDTO dto) {
        dto.setId(id);
        final User model = this.userConvertor.toModel(dto);
        this.userService.update(model);
        return this.userConvertor.toResultDTO(model);
    }

    /**
     * Delete model.
     *
     * @param id Unique ID.
     * @return The result of the model being deleted.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> delete(@PathVariable final Long id) {
        this.userService.delete(id);
        return ResultDTO.success();
    }
}
