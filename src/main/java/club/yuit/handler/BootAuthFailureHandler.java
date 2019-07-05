package club.yuit.handler;

import club.yuit.response.HttpResponseUtils;
import club.yuit.utils.HttpUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuit
 * @date 2019/7/3 15:49
 * 登录失败处理器
 **/
@Component
public class BootAuthFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        HttpUtils.writerError(HttpResponseUtils.baseResponse(401,"登录失败！检查用户名和密码"),response);
    }



}
