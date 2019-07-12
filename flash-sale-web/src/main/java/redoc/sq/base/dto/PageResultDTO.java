package redoc.sq.base.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;
import redoc.sq.base.conts.ApiResultCode;
import redoc.sq.base.exceptions.CustomRuntimeException;

import java.util.List;

public class PageResultDTO<T> extends ListResultDTO<T> {

    private PageData pageable;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "data", index = 2)
    @Override
    public List<T> getData() {
        return super.getData();
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "pageable", index = 3)
    public PageData getPageable() {
        return this.pageable;
    }

    public void setPageable(final PageData pageable) {
        this.pageable = pageable;
    }

    public PageResultDTO() {
    }

    public PageResultDTO(final String code) {
        super(code);
    }

    public static <T> PageResultDTO<T> success(final Page<T> pageData) {
        if (pageData == null) {
            throw new CustomRuntimeException("500", "NullPointerException",
                    "The formal parameter 'pageData' cannot be null");
        }

        final PageResultDTO<T> result = new PageResultDTO<>(ApiResultCode.SUCCESSFUL_STATUS);
        result.setData(pageData.getContent());
        result.setPageable(PageData.convert(pageData));
        return result;
    }

    public static <T> PageResultDTO<T> success(final List<T> listData, final Page<?> pageData) {
        if (pageData == null) {
            throw new CustomRuntimeException("500", "NullPointerException",
                    "The formal parameter 'pageData' cannot be null");
        }

        final PageResultDTO<T> result = new PageResultDTO<>(ApiResultCode.SUCCESSFUL_STATUS);
        result.setData(listData);
        result.setPageable(PageData.convert(pageData));
        return result;
    }
}
