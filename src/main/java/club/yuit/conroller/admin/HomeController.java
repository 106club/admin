package club.yuit.conroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019/7/4 11:04
 **/
@Controller
@RequestMapping("/admin/home")
public class HomeController {

    @GetMapping
    public String homePage() {
        return "admin/home";
    }


    @GetMapping("/detail")
    public String homeDetailsPage() {
        return "admin/home-detail";
    }

}
