package club.yuit.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019-07-08 20:10
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

    @GetMapping
    public String contactPage(){
        return "contact";
    }

}
