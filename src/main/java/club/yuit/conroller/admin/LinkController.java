package club.yuit.conroller.admin;

import club.yuit.entity.Link;
import club.yuit.response.BaseResponse;
import club.yuit.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuit
 * @date 2019-07-09 21:23
 */
@Controller
@RequestMapping("/admin/link")
public class LinkController {

    @Autowired
    private LinkService service;

    @GetMapping
    public String linkPage(Model model) {

        model.addAttribute("links", service.findLinks());

        return "admin/link";
    }


    @GetMapping("/detail")
    public String linkDetailPage(HttpServletRequest request, Model model) {

        String id = request.getParameter("id");
        Link link = null;

        if (id != null) {
            link = service.getById(id);
        }

        if (link == null) {
            link = new Link();
        }

        model.addAttribute("link", link);

        return "admin/link-detail";
    }


    @PostMapping
    @ResponseBody
    public BaseResponse addOrModify(@RequestBody Link t) {
        return this.service.addOrModify(t);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public BaseResponse delete(@PathVariable String id) {
        return this.service.deleteById(id);
    }

}
