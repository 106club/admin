package club.yuit.conroller;

import club.yuit.entity.ContactUs;
import club.yuit.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019-07-08 20:10
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactUsService usService;

    @GetMapping
    public String contactPage(Model model){

        ContactUs us= this.usService.getById("contact_id_123123");

        if (us==null){
            us=new ContactUs();
        }


        model.addAttribute("us",us);


        return "contact";
    }

}
