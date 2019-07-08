package club.yuit.conroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019/7/4 11:06
 **/
@Controller
@RequestMapping("/admin/introduction")
public class IntroductionController {


    @GetMapping
    public String introductionPage() {
        return "admin/introduction";
    }


    @GetMapping("/detail")
    public String introductionDetailPage() {
        return "admin/introduction-detail";
    }

}
