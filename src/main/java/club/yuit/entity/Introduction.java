package club.yuit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yuit
 * @date 2019/7/17 9:16
 **/
@Data
@TableName("introduction")
public class Introduction {

    @TableId(type = IdType.UUID)
    private String id="introduction_123";
    private String content;

}
