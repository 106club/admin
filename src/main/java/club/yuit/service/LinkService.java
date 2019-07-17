package club.yuit.service;

import club.yuit.entity.Link;
import club.yuit.response.BaseResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author yuit
 * @date 2019/7/17 16:20
 **/
public interface LinkService extends IService<Link> {

    List<Link> findLinks();
    BaseResponse addOrModify(Link l);
    BaseResponse deleteById(String id);

}
