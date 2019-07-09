package club.yuit.conroller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuit
 * @date 2019-07-09 21:38
 */
@Controller
@RequestMapping("/admin/message")
public class MessageController {

    @GetMapping
    public String msgPage(){
        return "admin/message";
    }

    @GetMapping("/detail")
    public String msgDetailPage(){
        return "admin/message-detail";
    }

}
