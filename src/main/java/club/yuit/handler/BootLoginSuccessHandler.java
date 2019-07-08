package club.yuit.handler;

import club.yuit.response.HttpResponseUtils;
import club.yuit.response.SimpleResponse;
import club.yuit.utils.HttpUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuit
 * @date 2019/7/8 11:01
 * 登录成功处理器
 **/
@Component
public class BootLoginSuccessHandler implements AuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SavedRequest sq = requestCache.getRequest(request,response);
        SimpleResponse<String> respJson = HttpResponseUtils.simpleResponse(200,null,"/admin");

        if (sq!=null){
            respJson.setItem(sq.getRedirectUrl());
        }
        HttpUtils.writerMsg(respJson,response);
    }
}
