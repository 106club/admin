package club.yuit.conroller;


import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;


/**
 * @author yuit
 * @date 2019/7/2 22:09
 */
@Controller
public class MainController  {


    @GetMapping("/")
    public String index(){
        return "index";
    }




}
