package club.yuit.conroller;

import club.yuit.entity.AboutUs;
import club.yuit.service.AboutUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019-07-08 20:09
 */
@Controller
@RequestMapping("/about")
public class AboutController {

    @Autowired
    private AboutUsService aboutUsService;

    @GetMapping
    public String aboutPage(Model model){
        AboutUs abs = this.aboutUsService.getById("about_us_123");
        model.addAttribute("abs",abs);
        return "about";
    }

}
