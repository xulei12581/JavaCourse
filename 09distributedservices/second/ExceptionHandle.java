package io.kimmking.rpcfx.exception;


/***
 * 异常处理类
 */
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandle {

    @ResponseBody
    @ExceptionHandler(value = RpcfxException.class)
    public ResultVO<Object> hander(RpcfxException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }
}