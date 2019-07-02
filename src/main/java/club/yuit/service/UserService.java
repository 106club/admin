package club.yuit.service;

import club.yuit.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author yuit
 * @date 2019/7/2 22:09
 */
public interface UserService extends IService<User> {

    User findUserByUsername(String username);

}
