package club.yuit.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yuit
 * @date 2019/7/10 10:17
 **/
@Data
@TableName("contact_us")
public class ContactUs {

    private String id="contact_id_123123";
    private String address;
    private String fax;
    private String email;
    private String phone;
    @TableField("wei_chat")
    private String weiChat;
    private String qq;

}
