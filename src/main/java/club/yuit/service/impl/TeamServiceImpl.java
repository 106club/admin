package club.yuit.service.impl;

import club.yuit.entity.Team;
import club.yuit.mapper.TeamMapper;
import club.yuit.response.BaseResponse;
import club.yuit.response.HttpResponseUtils;
import club.yuit.service.TeamService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuit
 * @date 2019/7/17 15:32
 **/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements TeamService {
    @Override
    public List<Team> findTeams() {
        QueryWrapper<Team> wrapper = new QueryWrapper<>();
        wrapper.select("id","phone","name","wei_chat","qq","sort");
        wrapper.orderByAsc("sort");
        return this.list(wrapper);
    }

    @Override
    public BaseResponse deleteById(String id) {
        this.removeById(id);
        return HttpResponseUtils.successResponse();
    }

    @Override
    public BaseResponse addOrModify(Team t) {

        if (t.getId()==null){
            this.save(t);
        }else {
            this.updateById(t);
        }

        return HttpResponseUtils.successResponse();
    }
}
