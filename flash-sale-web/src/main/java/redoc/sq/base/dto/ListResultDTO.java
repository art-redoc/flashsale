package redoc.sq.base.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import redoc.sq.base.conts.ApiResultCode;
import redoc.sq.base.exceptions.CustomRuntimeException;

import java.util.List;

public class ListResultDTO<T> extends AbstractResultDTO {

    protected List<T> data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "data", index = 3)
    public List<T> getData() {
        return this.data;
    }

    public void setData(final List<T> data) {
        this.data = data;
    }

    public ListResultDTO() {
    }

    ListResultDTO(final String code) {
        this.code = code;
    }

    public static <T> ListResultDTO<T> success(final List<T> listData) {
        if (listData == null) {
            throw new CustomRuntimeException("500", "NullPointerException",
                    "The formal parameter 'listData' cannot be null");
        }

        final ListResultDTO<T> result = new ListResultDTO<>(ApiResultCode.SUCCESSFUL_STATUS);
        result.setData(listData);
        return result;
    }

    public static <T> ListResultDTO<T> failure(final List<T> listData, final ResultError... errors) {
        final ListResultDTO<T> result = new ListResultDTO<>(ApiResultCode.FAILED_STATUS);
        result.setData(listData);
        result.setErrors(errors);
        return result;
    }
}
