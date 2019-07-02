package club.yuit.service.impl;

import club.yuit.entity.User;
import club.yuit.mapper.UserMapper;
import club.yuit.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author yuit
 * @date 2019/7/2 22:09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User findUserByUsername(String username) {
        return this.baseMapper.findUserByUsername(username);
    }
}
