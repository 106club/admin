package club.yuit.service.impl;

import club.yuit.entity.AboutUs;
import club.yuit.mapper.AboutUsMapper;
import club.yuit.service.AboutUsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author yuit
 * @date 2019/7/10 16:21
 **/
@Service
public class AboutUsServiceImpl extends ServiceImpl<AboutUsMapper, AboutUs> implements AboutUsService {
}
