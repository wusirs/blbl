package com.heisenberg.blbl.enums;

/**
 * 定义返回数据结构
 * @author Heisenberg
 * @date 2024-02-28 21:20:20
 * @version 1.0
 */
public interface IResult {
    /**
     * 获取状态码
     * @return {@link Integer}
     * @author Heisenberg
     * @date 2024/2/28 21:21
     */
    Integer getCode();

    /**
     * 获取消息体
     * @return {@link String}
     * @author Heisenberg
     * @date 2024/2/28 21:21
     */
    String getMessage();
}
