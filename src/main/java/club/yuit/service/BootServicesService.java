package club.yuit.service;

import club.yuit.entity.BootService;
import club.yuit.response.BaseResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author yuit
 * @date 2019/7/11 11:26
 **/

public interface BootServicesService extends IService<BootService> {

    BaseResponse addOrModify(BootService service);

    List<BootService> findServicesBySort();

}
