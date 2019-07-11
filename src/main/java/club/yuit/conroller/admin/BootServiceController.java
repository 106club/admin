package club.yuit.conroller.admin;

import club.yuit.entity.BootService;
import club.yuit.response.BaseResponse;
import club.yuit.response.HttpResponseUtils;
import club.yuit.service.BootServicesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author yuit
 * @date 2019-07-09 21:18
 */
@Controller
@RequestMapping("/admin/services")
public class BootServiceController {

    @Autowired
    private BootServicesService bs;

    @GetMapping
    public String servicePage(Model model) {
        List<BootService> services = bs.findServicesBySort();
        model.addAttribute("bs",services);
        return "admin/service";
    }

    @GetMapping("/detail")
    public String serviceDetailPage(HttpServletRequest request, Model model) {

        String id=request.getParameter("id");

        BootService service =null;

        if (id!=null&&!id.trim().equals("")){
            service=bs.getById(id);
        }

        if (service==null){
           service=new BootService();
        }

        model.addAttribute("bss",service);

        return "admin/service-detail";
    }


    @PostMapping
    @ResponseBody
    public BaseResponse addOrModify(@RequestBody BootService service) {
        return bs.addOrModify(service);
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public BaseResponse deleteById(@PathVariable String id){
        this.bs.removeById(id);
        return HttpResponseUtils.successResponse();
    }

}
