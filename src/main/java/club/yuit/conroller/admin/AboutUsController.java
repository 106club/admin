package club.yuit.conroller.admin;

import club.yuit.entity.AboutUs;
import club.yuit.response.BaseResponse;
import club.yuit.response.HttpResponseUtils;
import club.yuit.service.AboutUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yuit
 * @date 2019-07-09 21:21
 */
@Controller
@RequestMapping("/admin/aboutus")
public class AboutUsController {

    @Autowired
    private AboutUsService service;

    @GetMapping
    public String aboutUsPage(Model model, HttpServletRequest request){


        AboutUs abs=this.service.getById("about_us_123");

        if (abs==null){
            abs = new AboutUs();
        }
        model.addAttribute("abs",abs);

        return "admin/aboutus";
    }


    @PostMapping
    @ResponseBody
    public BaseResponse modify(@RequestBody AboutUs abs){

        abs.setContent(abs.getContent().replace("'","\\'"));

        if (abs.getId()==null||abs.getId().equals("null")||abs.getId().equals("")){
            abs.setId("about_us_123");
            this.service.save(abs);
        }else {
            this.service.updateById(abs);
        }

        return HttpResponseUtils.successResponse();
    }




}
