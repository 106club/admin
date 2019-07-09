package club.yuit.conroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019-07-09 21:23
 */
@Controller
@RequestMapping("/admin/link")
public class LinkController {

    @GetMapping
    public String linkPage(){
        return "admin/link";
    }


    @GetMapping("/detail")
    public String linkDetailPage(){
        return "admin/link-detail";
    }


}
