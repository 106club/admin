package club.yuit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yuit
 * @date 2019/7/11 11:23
 **/
@Data
@TableName("service")
public class BootService {

    @TableId(type = IdType.UUID)
    private String id;
    private String title;
    private String content;
    private Integer sort;

}
