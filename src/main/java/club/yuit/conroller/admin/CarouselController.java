package club.yuit.conroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019/7/4 11:08
 **/
@Controller
@RequestMapping("/admin/carousel")
public class CarouselController {

    @GetMapping
    public String carouselPage(){
        return "admin/carousel";
    }

    @GetMapping("/detail")
    public String carouselDetailPage(){
        return "admin/carousel-detail";
    }
}
