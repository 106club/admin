package club.yuit.service.impl;

import club.yuit.entity.BootService;
import club.yuit.mapper.ServiceMapper;
import club.yuit.response.BaseResponse;
import club.yuit.response.HttpResponseUtils;
import club.yuit.service.BootServicesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuit
 * @date 2019/7/11 11:26
 **/
@Service
public class BootServicesServiceImpl extends ServiceImpl<ServiceMapper, BootService> implements BootServicesService {
    @Override
    public BaseResponse addOrModify(BootService service) {

        if (service.getId()==null||service.getId().trim().equals("")){
            this.baseMapper.insert(service);
        }else {
            this.baseMapper.updateById(service);
        }
        return HttpResponseUtils.successResponse();
    }

    @Override
    public List<BootService> findServicesBySort() {
        QueryWrapper<BootService> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort");
        wrapper.select("id","title","sort");
        return this.list(wrapper);
    }
}
