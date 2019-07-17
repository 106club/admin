package club.yuit.service;

import club.yuit.entity.Case;
import club.yuit.response.BaseResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author yuit
 * @date 2019/7/17 10:17
 **/
public interface CaseService extends IService<Case> {

    List<Case> findCases();

    BaseResponse addOrModify(Case cas);

    BaseResponse deleteById(String id);

}
