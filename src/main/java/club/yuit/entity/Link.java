package club.yuit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yuit
 * @date 2019/7/17 16:16
 **/
@Data
@TableName("link")
public class Link {


    @TableId(type = IdType.UUID)
    private String id;
    private String name;
    private String link;
    private Integer sort;
    private String description;

}
