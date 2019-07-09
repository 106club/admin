package club.yuit.service;

import club.yuit.entity.Carousel;
import club.yuit.response.BaseResponse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author yuit
 * @date 2019/7/9 11:03
 **/
public interface CarouselService extends IService<Carousel> {

    BaseResponse addOrModifyCarousel(Carousel carousel);

    BaseResponse deleteById(String id);

}
