package art.redoc.business.goods.controller;

import art.redoc.core.dto.PageResultDTO;
import art.redoc.core.dto.ResultDTO;
import art.redoc.business.goods.service.UserService;
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
import art.redoc.business.goods.repository.UserRepository;

import javax.validation.Valid;

/**
 * User的管理接口
 *
 * @author auto
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserConvertor userConvertor;
    @Autowired
    private UserRepository userRepository;

    /**
     * 获取分页数据
     *
     * @param pageable 分页+排序参数
     * @return 分页数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResultDTO<UserDTO> search(final Pageable pageable) {
        final Page<User> models = this.userRepository.findAll(pageable);
        return this.userConvertor.toResultDTO(models);
    }
    /**
     * 取得详细数据
     *
     * @param id 资源ID
     * @return 资源详细
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<UserDTO> get(@PathVariable final Long id) {
        final User model = this.userService.get(id);
        ResultDTO<UserDTO> resultDTO = this.userConvertor.toResultDTO(model);
        return resultDTO;
    }

    /**
     * 新建操作
     *
     * @param userDTO 新建资源的DTO
     * @return 新建资源
     */
    @RequestMapping(method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<UserDTO> create(@RequestBody @Valid final UserDTO userDTO) {
        final User model = this.userConvertor.toModel(userDTO);
        this.userService.create(model);
        return this.userConvertor.toResultDTO(model);
    }
    
    /**
     * 更新操作
     *
     * @param id 更新资源的ID
     * @param userDTO 更新资源的DTO
     * @return 更新后资源
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<UserDTO> update(@PathVariable final Long id, @RequestBody @Valid final UserDTO userDTO) {
        userDTO.setId(id);
        final User model = this.userConvertor.toModel(userDTO);
        this.userService.update(model);
        return this.userConvertor.toResultDTO(model);
    }

    /**
     * 删除操作
     *
     * @param id 资源ID
     * @return 操作结果
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> delete(@PathVariable final Long id) {
        this.userService.delete(id);
        return ResultDTO.success();
    }
}