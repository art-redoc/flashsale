package redoc.sq.base.dto;

public class ResultError {

    /**
     * 错误信息
     */
    private String errmsg;
    /**
     * 错误编码
     */
    private String errcode;

    public ResultError() {
    }

    public ResultError(final String errmsg) {
        this.errmsg = errmsg;
    }

    public ResultError(final String errcode, final String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public String getErrcode() {
        return this.errcode;
    }

    public void setErrcode(final String errcode) {
        this.errcode = errcode;
    }

    public void setErrmsg(final String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return String.format("{errcode:%s, errmsg:%s}", this.errcode, this.errmsg);
    }

}
