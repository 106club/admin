package club.yuit.service.impl;

import club.yuit.entity.Case;
import club.yuit.mapper.CaseMapper;
import club.yuit.response.BaseResponse;
import club.yuit.response.HttpResponseUtils;
import club.yuit.service.CaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author yuit
 * @date 2019/7/17 10:17
 **/
@Service
public class CaseServiceImpl extends ServiceImpl<CaseMapper, Case> implements CaseService {
    @Override
    public List<Case> findCases() {
        QueryWrapper<Case> wrapper = new QueryWrapper<>();
        wrapper.select("id", "title", "sort", "`time`");
        wrapper.orderByAsc("sort");
        return this.list(wrapper);
    }


    @Override
    public BaseResponse addOrModify(Case cas) {

        cas.setTime(new Timestamp(System.currentTimeMillis()));
        if (cas.getId() == null || cas.getId().trim().equals("")) {
            this.save(cas);
        } else {
            this.updateById(cas);
        }

        return HttpResponseUtils.successResponse();
    }

    @Override
    public BaseResponse deleteById(String id) {

        this.removeById(id);

        return HttpResponseUtils.successResponse();
    }
}
