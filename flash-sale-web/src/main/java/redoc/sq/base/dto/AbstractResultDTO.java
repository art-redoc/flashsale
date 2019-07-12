package redoc.sq.base.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import redoc.sq.base.conts.ApiResultCode;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractResultDTO {
    /**
     * 状态
     */
    @Getter
    @Setter
    @JsonProperty(value = "code", index = 0)
    protected String code;

    /**
     * 错误信息
     */
    protected ResultError[] errors;

    @JsonIgnore
    public boolean isSuccess() {
        return this.code.equals(ApiResultCode.SUCCESSFUL_STATUS) ? true : false;
    }

    @JsonIgnore
    public boolean isFailure() {
        return this.code.equals(ApiResultCode.SUCCESSFUL_STATUS) ? false : true;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "errors", index = 1)
    public ResultError[] getErrors() {
        return this.errors;
    }

    protected void setErrors(final ResultError... errors) {
        this.errors = errors;
    }

    @JsonIgnore
    public String errorsToString() {
        if ((this.errors != null) && (this.errors.length > 0)) {
            final StringBuilder builder = new StringBuilder();
            builder.append("Errors : [");
            for (final ResultError error : this.errors) {
                builder.append(error.toString());
            }
            builder.append("]");
            return builder.toString();
        } else {
            return "errors : []";
        }
    }
}
