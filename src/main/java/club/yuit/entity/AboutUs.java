package club.yuit.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yuit
 * @date 2019/7/10 15:42
 **/
@Data
@TableName("about_us")
public class AboutUs {

    private String id="about_us_123";
    private String title;
    private String image;
    private String description;
    private String content;
}
