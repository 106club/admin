package club.yuit.handler;

import club.yuit.exception.ArgumentsFailureException;
import club.yuit.exception.NotAuthorityException;
import club.yuit.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;

import static club.yuit.response.HttpResponseUtils.baseResponse;

/**
 * @author yuit
 * @date 2019/5/5 17:15
 **/
@RestControllerAdvice
public class BootExceptionHandler {

    /**
     * 404
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseResponse notFoundException(HttpServletResponse response) {
        return baseResponse(404, "找不到服务");
    }


    @ExceptionHandler(value = ArgumentsFailureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse argumentException(){
        return baseResponse(400,"参数错误");
    }


    @ExceptionHandler(value = NotAuthorityException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public BaseResponse notAuthority(){
        return baseResponse(HttpStatus.FORBIDDEN.value(),"没有权限");
    }


}
