package club.yuit.handler;

import club.yuit.response.HttpResponseUtils;
import club.yuit.utils.HttpUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuit
 * @date 2019/7/5 15:30
 **/
@Component
public class BootAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        HttpUtils.writerError(HttpResponseUtils.baseResponse(403,"没有权限访问"),response);
    }
}
