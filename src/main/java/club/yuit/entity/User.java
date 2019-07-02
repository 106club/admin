package club.yuit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author yuit
 * @date 2019/7/2 22:09
 */
@TableName("user")
@Data
public class User {
    @TableId(type = IdType.UUID)
    private String id;
    private String username;
    private String password;
    private Timestamp lastLoginTime;
}
