package art.redoc.business.test.controller;

import art.redoc.business.test.convertor.TestConvertor;
import art.redoc.business.test.dto.TestDTO;
import art.redoc.business.test.model.Test;
import art.redoc.business.test.service.TestService;
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

import javax.validation.Valid;

/**
 * Test的管理接口
 *
 * @author auto
 */
@Slf4j
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private TestConvertor testConvertor;

    /**
     * 获取分页数据
     *
     * @param pageable 分页+排序参数
     * @return 分页数据
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResultDTO<TestDTO> search(final Pageable pageable) {
        final Page<Test> models = this.testService.getAll(pageable);
        return this.testConvertor.toResultDTO(models);
    }

    /**
     * 取得详细数据
     *
     * @param id 资源ID
     * @return 资源详细
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<TestDTO> get(@PathVariable final Long id) {
        final Test model = this.testService.get(id);
        return this.testConvertor.toResultDTO(model);
    }

    /**
     * 新建操作
     *
     * @param testDTO 新建资源的DTO
     * @return 新建资源
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<TestDTO> create(@RequestBody @Valid final TestDTO testDTO) {
        final Test model = this.testConvertor.toModel(testDTO);
        this.testService.create(model);
        return this.testConvertor.toResultDTO(model);
    }

    /**
     * 更新操作
     *
     * @param id      更新资源的ID
     * @param testDTO 更新资源的DTO
     * @return 更新后资源
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<TestDTO> update(@PathVariable final Long id, @RequestBody @Valid final TestDTO testDTO) {
        testDTO.setId(id);
        final Test model = this.testConvertor.toModel(testDTO);
        this.testService.update(model);
        return this.testConvertor.toResultDTO(model);
    }

    /**
     * 删除操作
     *
     * @param id 资源ID
     * @return 操作结果
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> delete(@PathVariable final Long id) {
        this.testService.delete(id);
        return ResultDTO.success();
    }
}