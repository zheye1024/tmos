package cn.xlbweb.tmos.common.server;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: bobi
 * @date: 2018/7/16 14:52
 * @description:
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 失败
     */
    ERROR(1, "失败");

    private final int code;
    private final String msg;
}
