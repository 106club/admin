package club.yuit.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author yuit
 * @date 2019/7/17 10:15
 **/
@Data
@TableName("`case`")
public class Case {

    private String id;
    private String title;
    @TableField("sub_title")
    private String subTitle;
    private String content;

    private Integer sort;

    @TableField("`time`")
    private Timestamp time;

}
