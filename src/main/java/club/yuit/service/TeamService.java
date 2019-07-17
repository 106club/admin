package club.yuit.service;

import club.yuit.entity.Team;
import club.yuit.response.BaseResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author yuit
 * @date 2019/7/17 15:32
 **/
public interface TeamService extends IService<Team> {

    List<Team> findTeams();
    BaseResponse deleteById(String id);
    BaseResponse addOrModify(Team t);
}
