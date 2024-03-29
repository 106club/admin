package club.yuit.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuit
 * @date   2018/3/30 20:37
 *
 */
@Data
public  class BaseResponse implements Serializable {

    private int status;
    private String msg;

    protected BaseResponse() {
    }

    protected BaseResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
