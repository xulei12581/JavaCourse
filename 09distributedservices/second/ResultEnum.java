package io.kimmking.rpcfx.exception;


/**
 * 返回信息枚举
 */
public enum ResultEnum {

    SUCCESS(0, "成功"),

    ERROR(1, "失败!"),

    PARAM_ERROR(2, "参数错误!");

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}