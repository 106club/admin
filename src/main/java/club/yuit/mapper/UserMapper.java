package club.yuit.mapper;

import club.yuit.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author yuit
 * @date 2019/7/2 22:09
 */
public interface UserMapper extends BaseMapper<User> {

    User findUserByUsername(String username);

}
