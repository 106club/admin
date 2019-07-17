package club.yuit.service.impl;

import club.yuit.entity.Introduction;
import club.yuit.mapper.IntroductionMapper;
import club.yuit.response.BaseResponse;
import club.yuit.response.HttpResponseUtils;
import club.yuit.service.IntroductionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author yuit
 * @date 2019/7/17 9:19
 **/
@Service
public class IntroductionServiceImpl extends ServiceImpl<IntroductionMapper, Introduction> implements IntroductionService {
    @Override
    public BaseResponse addOrModify(Introduction in) {

        in.setContent(in.getContent().replace("'","\\'"));

        if (in.getId()==null||in.getId().trim().equals("")){
            in.setId("introduction_123");
            this.save(in);
        }else {
            this.updateById(in);
        }
        return HttpResponseUtils.successResponse();
    }
}
