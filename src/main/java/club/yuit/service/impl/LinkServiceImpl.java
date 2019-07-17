package club.yuit.service.impl;

import club.yuit.entity.Link;
import club.yuit.mapper.LinkMapper;
import club.yuit.response.BaseResponse;
import club.yuit.response.HttpResponseUtils;
import club.yuit.service.LinkService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuit
 * @date 2019/7/17 16:21
 **/
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public List<Link> findLinks() {
        QueryWrapper<Link> wrapper = new QueryWrapper<>();
        wrapper.select("id", "sort", "name", "link");
        wrapper.orderByAsc("sort");
        return this.list(wrapper);
    }

    @Override
    public BaseResponse addOrModify(Link l) {

        if (l.getId() == null) {
            this.save(l);
        } else {
            this.updateById(l);
        }


        return HttpResponseUtils.successResponse();
    }

    @Override
    public BaseResponse deleteById(String id) {
        this.removeById(id);
        return HttpResponseUtils.successResponse();
    }
}
