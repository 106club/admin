package club.yuit.conroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019-07-09 21:17
 */
@Controller
@RequestMapping("/admin/team")
public class TeamController {

    @GetMapping
    public String teamPage(){
        return "admin/team";
    }

    @GetMapping("/detail")
    public String teamDetailPage(){
        return "admin/team-detail";
    }

}
