package club.yuit.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author yuit
 * @date 2019/4/9 16:10
 */
@Component
public class BootPictureCodeAuthenticationFilter extends OncePerRequestFilter {


    private AntPathMatcher pathMatcher= new AntPathMatcher();


    public BootPictureCodeAuthenticationFilter() {

    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //本次请求url
        String path = request.getRequestURI();


        if (pathMatcher.match("/user/auth",path)) {

            // 图片验证码值
            String pCode = request.getParameter("pic_code");


            if(StringUtils.isBlank(pCode)){
                response.sendRedirect("/admin/login?error=code is blank");
                return;
            }

            HttpSession session=request.getSession();

            String pRealCode= (String) session.getAttribute("pic_code");

            if (pRealCode==null){
                response.sendRedirect("/admin/login?error=code is expire");
                return;
            }

            if (!StringUtils.equalsIgnoreCase(pCode,pRealCode)){
                response.sendRedirect("/admin/login?error=code is error");
                return;
            }

        }


        filterChain.doFilter(request,response);

    }


}
