package club.yuit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yuit
 * @date 2019/7/17 15:27
 **/
@Data
@TableName("team")
public class Team {

    @TableId(type = IdType.UUID)
    private String id;
    private String name;
    private String  phone;
    @TableField("wei_chat")
    private String weiChat;
    private String qq;
    private String description;
    private String image;
    private Integer sort;
}
