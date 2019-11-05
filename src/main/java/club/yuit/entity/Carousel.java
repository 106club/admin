package club.yuit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yuit
 * @date 2019/7/9 10:50
 **/
@Data
@TableName("carousel")
public class Carousel {

    @TableId(type = IdType.UUID)
    private String id;
    private String title;
    @TableField("sub_title")
    private String subTitle;
    @TableField("image_url")
    private String imageUrl;

}
