package club.yuit.config;

import club.yuit.support.BootUserDetailService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author yuit
 * @date 2019/7/2 22:09
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private BootUserDetailService userDetailService;

    public WebSecurityConfiguration(BootUserDetailService userDetailService) {
        this.userDetailService = userDetailService;
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
                .antMatchers("/admin/**")
                .and()
                .authorizeRequests()
                .antMatchers("/admin/login","/admin/picture_code")
                .permitAll()
                .anyRequest()
                .authenticated();

        http.formLogin()
                .loginPage("/admin/login")
                .loginProcessingUrl("/user/auth")
                .and()
                .httpBasic().disable();



    }
}
