package art.redoc.business.test.convertor;

import art.redoc.core.convertors.AbstractConvertor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import art.redoc.business.test.dto.TestDTO;
import art.redoc.business.test.model.Test;
import art.redoc.business.test.service.TestService;

/**
 * Test Convertor.
 *
 * @author code generator
 */
@Component
public class TestConvertor extends AbstractConvertor<Test, TestDTO> {

    @Autowired
    private TestService testService;

    @Override
    public Test toModel(@NonNull final TestDTO dto) {
        if (dto.isNew()) {
            return constructModel(dto);
        } else {
            return updateModel(dto);
        }
    }

    @Override
    public TestDTO toDTO(@NonNull final Test model, final boolean forListView) {
        final TestDTO dto = new TestDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setTestEnum(model.getTestEnum());
        dto.setFatherId(model.getFatherId());
        dto.setPrice(model.getPrice());
        dto.setContent(model.getContent());
        dto.setIsDefault(model.getIsDefault());
        dto.setAcceptTime(model.getAcceptTime());
        dto.setForbiddenTime(model.getForbiddenTime());
        dto.setLocalTime(model.getLocalTime());

        return dto;
    }

    /**
     * Build the new model by DTO.
     *
     * @param dto DTO.
     * @return The newly built model.
     */
    private Test constructModel(final TestDTO dto) {
        Test model = new Test();
        model.setName(dto.getName());
        model.setTestEnum(dto.getTestEnum());
        model.setFatherId(dto.getFatherId());
        model.setPrice(dto.getPrice());
        model.setContent(dto.getContent());
        model.setIsDefault(dto.getIsDefault());
        model.setAcceptTime(dto.getAcceptTime());
        model.setForbiddenTime(dto.getForbiddenTime());
        model.setLocalTime(dto.getLocalTime());

        return model;
    }

    /**
     * Update the model by DTO.
     *
     * @param dto DTO.
     * @return The updated model.
     */
    private Test updateModel(final TestDTO dto) {
        Test model = testService.get(dto.getId());
        model.setName(dto.getName());
        model.setTestEnum(dto.getTestEnum());
        model.setFatherId(dto.getFatherId());
        model.setPrice(dto.getPrice());
        model.setContent(dto.getContent());
        model.setIsDefault(dto.getIsDefault());
        model.setAcceptTime(dto.getAcceptTime());
        model.setForbiddenTime(dto.getForbiddenTime());
        model.setLocalTime(dto.getLocalTime());

        return model;
    }
}