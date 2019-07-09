package club.yuit.conroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019-07-09 21:18
 */
@Controller
@RequestMapping("/admin/services")
public class AdminServiceController {

    @GetMapping
    public String servicePage(){
        return "admin/service";
    }

    @GetMapping("/detail")
    public String serviceDetailPage(){
        return "admin/service-detail";
    }

}
