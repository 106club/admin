package club.yuit.service.impl;

import club.yuit.entity.Carousel;
import club.yuit.mapper.CarouselMapper;
import club.yuit.response.BaseResponse;
import club.yuit.response.HttpResponseUtils;
import club.yuit.service.CarouselService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author yuit
 * @date 2019/7/9 11:03
 **/
@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {
    @Override
    public BaseResponse addOrModifyCarousel(Carousel carousel) {

        if (carousel.getId()==null||carousel.getId().equals("")){
            carousel.setId(null);
            this.baseMapper.insert(carousel);
        }else {
            this.baseMapper.updateById(carousel);
        }

        return HttpResponseUtils.successResponse();
    }

    @Override
    public BaseResponse deleteById(String id) {
        this.removeById(id);
        return HttpResponseUtils.successResponse();
    }
}
