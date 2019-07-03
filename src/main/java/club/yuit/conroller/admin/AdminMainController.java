package club.yuit.conroller.admin;


import club.yuit.filter.BootPictureCodeAuthenticationFilter;
import club.yuit.support.PictureCodeGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuit
 * @date 2019/7/2 22:09
 */
@Controller
@RequestMapping("/admin")
public class AdminMainController {


    @GetMapping("/home")
    public String index(){
        return "admin/index";
    }


    @GetMapping("/login")
    public String loginPage(){
        return "admin/login";
    }


    @GetMapping("/picture_code")
    public void pictureCodeGenerate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PictureCodeGenerator.generate(response,request.getSession());
    }



}
