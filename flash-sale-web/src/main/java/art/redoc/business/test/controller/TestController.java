package art.redoc.business.test.controller;

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

import art.redoc.business.test.convertor.TestConvertor;
import art.redoc.business.test.dto.TestDTO;
import art.redoc.business.test.model.Test;
import art.redoc.business.test.service.TestService;

import javax.validation.Valid;

/**
 * Test controller.
 *
 * @author code generator
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
     * Get model list.
     *
     * @param pageable Paging related params.
     * @return Model list.
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResultDTO<TestDTO> search(final Pageable pageable) {
        final Page<Test> models = this.testService.getAll(pageable);
        return this.testConvertor.toResultDTO(models);
    }

    /**
     * Get detail model by unique ID.
     *
     * @param id Unique ID.
     * @return Detail model.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<TestDTO> get(@PathVariable final Long id) {
        final Test model = this.testService.get(id);
        return this.testConvertor.toResultDTO(model);
    }

    /**
     * Create model.
     *
     * @param testDTO The model DTO.
     * @return DTO of the model that needs to be created.
     */
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<TestDTO> create(@RequestBody @Valid final TestDTO testDTO) {
        final Test model = this.testConvertor.toModel(testDTO);
        this.testService.create(model);
        return this.testConvertor.toResultDTO(model);
    }

    /**
     * Update model.
     *
     * @param id  Unique ID.
     * @param dto DTO of the model that needs to be updated.
     * @return Updated model DTO.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<TestDTO> update(@PathVariable final Long id, @RequestBody @Valid final TestDTO dto) {
        dto.setId(id);
        final Test model = this.testConvertor.toModel(dto);
        this.testService.update(model);
        return this.testConvertor.toResultDTO(model);
    }

    /**
     * Delete model.
     *
     * @param id Unique ID.
     * @return The result of the model being deleted.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> delete(@PathVariable final Long id) {
        this.testService.delete(id);
        return ResultDTO.success();
    }
}