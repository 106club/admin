package club.yuit.conroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019/7/4 14:36
 **/
@Controller
@RequestMapping("/admin/welcome")
public class WelcomeController {

    @GetMapping
    public String welcomePage(){
        return "admin/welcome";
    }




}
