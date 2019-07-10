package club.yuit.service.impl;

import club.yuit.entity.ContactUs;
import club.yuit.mapper.ContactUsMapper;
import club.yuit.service.ContactUsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author yuit
 * @date 2019/7/10 10:23
 **/
@Service
public class ContactUsServiceImpl extends ServiceImpl<ContactUsMapper, ContactUs> implements ContactUsService {
}
