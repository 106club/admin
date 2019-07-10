package club.yuit.conroller.admin;

import club.yuit.entity.ContactUs;
import club.yuit.response.BaseResponse;
import club.yuit.response.HttpResponseUtils;
import club.yuit.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yuit
 * @date 2019-07-09 21:13
 */
@Controller
@RequestMapping("/admin/contactus")
public class ContactUsController {

    @Autowired
    private ContactUsService service;

    @GetMapping
    public String contactUsPage(Model model){

        ContactUs c =new ContactUs();
        List<ContactUs> cs = service.list();

        if (cs.size()>0){
            c = cs.get(0);
        }
        model.addAttribute("cus",c);
        return "admin/contactus";
    }


    @PostMapping
    @ResponseBody
    public BaseResponse modify(@ModelAttribute ContactUs c){

        if (c.getId()==null){
            c.setId("contact_id_123123");
        }

        if (this.service.getById("contact_id_123123")==null){
            this.service.save(c);
        }else {
            this.service.updateById(c);
        }
        return HttpResponseUtils.successResponse();
    }

}
