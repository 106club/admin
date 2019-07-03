package club.yuit.config;

import club.yuit.filter.BootPictureCodeAuthenticationFilter;
import club.yuit.handler.BootAuthFailureHandler;
import club.yuit.support.BootUserDetailService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author yuit
 * @date 2019/7/2 22:09
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private BootUserDetailService userDetailService;
    private BootPictureCodeAuthenticationFilter pictureCodeAuthenticationFilter;
    private BootAuthFailureHandler authFailureHandler;

    public WebSecurityConfiguration(BootUserDetailService userDetailService,
                                    BootPictureCodeAuthenticationFilter pictureCodeAuthenticationFilter,
                                    BootAuthFailureHandler authFailureHandler) {
        this.userDetailService = userDetailService;
        this.pictureCodeAuthenticationFilter = pictureCodeAuthenticationFilter;
        this.authFailureHandler = authFailureHandler;
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
        http.requestMatchers()
                .antMatchers("/admin/**","/admin/login","/user/auth")
                .and()
                .authorizeRequests()
                .antMatchers("/admin/login","/admin/picture_code","/user/auth")
                .permitAll()
                .anyRequest()
                .authenticated();

        http.formLogin()
                .loginPage("/admin/login")
                .loginProcessingUrl("/user/auth")
                // 登录失败处理器
                .failureHandler(authFailureHandler)
                .and()
                // 禁用 http basic 登录
                .httpBasic().disable();

        // 图片验证码，在用户认证之前
        http.addFilterBefore(this.pictureCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
