package club.yuit.conroller.admin;

import club.yuit.entity.Introduction;
import club.yuit.response.BaseResponse;
import club.yuit.service.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author yuit
 * @date 2019/7/4 11:06
 **/
@Controller
@RequestMapping("/admin/introduction")
public class IntroductionController {

    @Autowired
    private IntroductionService service;

    @GetMapping
    public String introductionPage(Model model) {

        Introduction introduction=service.getById("introduction_123");

        if (introduction==null){
            introduction = new Introduction();
            introduction.setId(null);
        }

        model.addAttribute("in",introduction);

        return "admin/introduction";
    }


    @PostMapping
    @ResponseBody
    public BaseResponse addOrModify(@RequestBody Introduction in){
        return this.service.addOrModify(in);
    }

}
