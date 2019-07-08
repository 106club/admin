package club.yuit.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019-07-08 20:05
 */
@Controller
@RequestMapping("/services")
public class ServiceController {

    @GetMapping
    public String servicesPage(){
        return "services";
    }

}
