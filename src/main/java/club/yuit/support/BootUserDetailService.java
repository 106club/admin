package club.yuit.support;

import club.yuit.entity.User;
import club.yuit.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author yuit
 * @date 2019/7/2 22:09
 */
@Component
public class BootUserDetailService implements UserDetailsService {

    private UserService userService;

    public BootUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = this.userService.findUserByUsername(s);

        if (user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return new BootUserDetails(user);
    }
}
