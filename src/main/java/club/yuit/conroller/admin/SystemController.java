package club.yuit.conroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019-07-09 21:28
 */
@Controller
@RequestMapping("/admin/sys")
public class SystemController {

    @GetMapping
    public String sysPage(){
        return "admin/system";
    }

}
