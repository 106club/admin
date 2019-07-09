package club.yuit.conroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019-07-09 21:13
 */
@Controller
@RequestMapping("/admin/contactus")
public class ContactUsController {

    @GetMapping
    public String contactUsPage(){
        return "admin/contactus";
    }

    @GetMapping("/detail")
    public String contactUsDetailPage(){
        return "admin/contactus-detail";
    }

}
