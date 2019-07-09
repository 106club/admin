package club.yuit.conroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019-07-09 21:21
 */
@Controller
@RequestMapping("/admin/aboutus")
public class AboutUsController {

    @GetMapping
    public String aboutUsPage(){
        return "admin/aboutus";
    }


    @GetMapping("/detail")
    public String aboutUsDetailPage(){
        return "admin/aboutus-detail";
    }


}
