package club.yuit.conroller.admin;

import club.yuit.entity.Carousel;
import club.yuit.response.BaseResponse;
import club.yuit.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * @author yuit
 * @date 2019/7/4 11:08
 **/
@Controller
@RequestMapping("/admin/carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @GetMapping
    public String carouselPage(Model model){

        model.addAttribute("carousels",this.carouselService.listCarousel());

        return "admin/carousel";
    }

    @GetMapping("/detail")
    public String carouselDetailPage(Model model, HttpServletRequest request){

        String id=request.getParameter("id");
        Carousel carousel = null;

        if (id!=null){
            carousel=this.carouselService.getById(id);
        }

        if (carousel==null){
            carousel =new Carousel();
        }


        model.addAttribute("title",carousel.getTitle());
        model.addAttribute("sub_title",carousel.getSubTitle());
        model.addAttribute("image_code",carousel.getImageCode()==null? "": carousel.getImageCode());
        return "admin/carousel-detail";
    }


    @PostMapping
    @ResponseBody
    public BaseResponse addOrModifyCarousel(@RequestBody Carousel carousel){
        return this.carouselService.addOrModifyCarousel(carousel);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public BaseResponse deleteCarousel(@PathVariable  String id){
        return this.carouselService.deleteById(id);
    }

}

