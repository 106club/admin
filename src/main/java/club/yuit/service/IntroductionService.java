package club.yuit.service;

import club.yuit.entity.Introduction;
import club.yuit.response.BaseResponse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author yuit
 * @date 2019/7/17 9:18
 **/
public interface IntroductionService extends IService<Introduction> {

    BaseResponse addOrModify(Introduction in);

}
