package club.yuit.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019-07-08 20:07
 */
@Controller
@RequestMapping("/team")
public class ProfessionalTeamController {

    @GetMapping
    public String teamPage(){
        return "professional";
    }

}
