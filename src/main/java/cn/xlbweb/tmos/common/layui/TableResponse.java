package cn.xlbweb.tmos.common.layui;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: bobi
 * @date: 2018/7/17 10:57
 * @description:
 */
@Getter
@Setter
public class TableResponse<T> {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 总条数
     */
    private Long count;
    /**
     * 数据
     */
    private T data;

    public TableResponse(Long count, T data) {
        this.code = 0;
        this.msg = "查询成功";
        this.count = count;
        this.data = data;
    }
}
