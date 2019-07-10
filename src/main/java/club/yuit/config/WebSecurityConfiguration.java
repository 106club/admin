package club.yuit.config;

import club.yuit.filter.BootPictureCodeAuthenticationFilter;
import club.yuit.handler.BootAccessDeniedHandler;
import club.yuit.handler.BootAuthFailureHandler;
import club.yuit.handler.BootLoginSuccessHandler;
import club.yuit.support.BootUserDetailService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.session.InvalidSessionStrategy;

/**
 * @author yuit
 * @date 2019/7/2 22:09
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private BootUserDetailService userDetailService;
    private BootPictureCodeAuthenticationFilter pictureCodeAuthenticationFilter;
    private BootAuthFailureHandler authFailureHandler;
    private BootAccessDeniedHandler accessDeniedHandler;
    private BootLoginSuccessHandler successHandler;

    public WebSecurityConfiguration(BootUserDetailService userDetailService,
                                    BootPictureCodeAuthenticationFilter pictureCodeAuthenticationFilter,
                                    BootAuthFailureHandler authFailureHandler, BootAccessDeniedHandler accessDeniedHandler, BootLoginSuccessHandler successHandler) {
        this.userDetailService = userDetailService;
        this.pictureCodeAuthenticationFilter = pictureCodeAuthenticationFilter;
        this.authFailureHandler = authFailureHandler;
        this.accessDeniedHandler = accessDeniedHandler;
        this.successHandler = successHandler;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }

    /**
     * 可配置 忽略urls
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 匹配要做拦截处理的urls
        http.requestMatchers()
                .antMatchers("/admin/**","/user/auth")
                .and()
                .authorizeRequests()
                .antMatchers("/admin/login","/admin/picture_code","/user/auth","/admin/logout","/admin/**")
                .permitAll()
                .anyRequest()
                .authenticated();

        // 表单登录配置
        http.formLogin()
                .loginPage("/admin/login")
                .loginProcessingUrl("/user/auth")
                // 登录失败处理器
                .failureHandler(authFailureHandler)
                .successHandler(successHandler)
                .and()
                // 禁用 http basic 登录
                .httpBasic().disable();

        // session 配置
        http.sessionManagement()
                .maximumSessions(1); // 一个用户一个session

        // 注销配置
        http.logout()
                .logoutUrl("/admin/logout");

        // 异常处理
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);  // 处理 403

        // 请求头
        http.headers()
                .frameOptions()
                .sameOrigin();



        // 图片验证码，在用户认证之前
        http.addFilterBefore(this.pictureCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
