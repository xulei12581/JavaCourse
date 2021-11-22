package io.kimmking.rpcfx.exception;


/**
 * 通用error类
 * RuntimeException 会进行事务回滚 但是Exception不会
 */
public class RpcfxException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final Integer code;

    public Integer getCode() {
        return code;
    }

    public RpcfxException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /***
     * 自定义错误类
     * @param resultEnum
     */
    public RpcfxException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
