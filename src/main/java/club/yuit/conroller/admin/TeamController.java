package club.yuit.conroller.admin;

import club.yuit.entity.Case;
import club.yuit.entity.Team;
import club.yuit.response.BaseResponse;
import club.yuit.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuit
 * @date 2019-07-09 21:17
 */
@Controller
@RequestMapping("/admin/team")
public class TeamController {

    @Autowired
    private TeamService service;

    @GetMapping
    public String teamPage(Model model){

        model.addAttribute("teams",service.findTeams());

        return "admin/team";
    }

    @GetMapping("/detail")
    public String teamDetailPage(HttpServletRequest request, Model model){

        String id = request.getParameter("id");
        Team t = null;

        if (id != null) {
            t = service.getById(id);
        }

        if (t == null) {
            t = new Team();
        }

        model.addAttribute("team", t);


        return "admin/team-detail";
    }

    @PostMapping
    @ResponseBody
    public BaseResponse addOrModify(@RequestBody Team t) {
        return this.service.addOrModify(t);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public BaseResponse delete(@PathVariable String id) {
        return this.service.deleteById(id);
    }

}
