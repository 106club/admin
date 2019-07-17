package club.yuit.conroller.admin;

import club.yuit.entity.Case;
import club.yuit.response.BaseResponse;
import club.yuit.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.annotation.XmlAnyElement;

/**
 * @author yuit
 * @date 2019/7/4 11:04
 **/
@Controller
@RequestMapping("/admin/home")
public class HomeController {

    @Autowired
    private CaseService service;

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("cas", service.findCases());
        return "admin/home";
    }


    @GetMapping("/detail")
    public String homeDetailsPage(HttpServletRequest request, Model model) {

        String id = request.getParameter("id");
        Case cs = null;

        if (id != null) {
            cs = service.getById(id);
        }

        if (cs == null) {
            cs = new Case();
        }

        model.addAttribute("cs", cs);

        return "admin/home-detail";
    }

    @PostMapping
    @ResponseBody
    public BaseResponse addOrModify(@RequestBody Case cs) {
        return this.service.addOrModify(cs);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public BaseResponse delete(@PathVariable String id) {
        return this.service.deleteById(id);
    }


}
