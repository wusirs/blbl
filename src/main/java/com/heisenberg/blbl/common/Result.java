package com.heisenberg.blbl.common;

import com.heisenberg.blbl.enums.IResult;
import com.heisenberg.blbl.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

/**
 * @author Heisenberg
 * @date 2024-02-28 20:15:15
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T>{
    /**
     *状态码
     */
    private Integer code;

    /**
     * 消息体
     */
    private String message;
    private T data;


    /**
     *
     * @param data 返回值
     * @return {@link Result<T>}
     * @author Heisenberg
     * @date 2024/2/28 21:48
     */
    public static <T> Result<T> success(@NonNull T data){
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    /**
     *
     * @param message 返回信息
     * @param data 返回值
     * @return {@link Result<T>}
     * @author Heisenberg
     * @date 2024/2/28 21:49
     */
    public static <T> Result<T> success(@NonNull String message, @NonNull T data){
        return new Result<>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    /**
     * 调用失败
     * @return {@link Result<Object>}
     * @author Heisenberg
     * @date 2024/2/28 21:49
     */
    public static Result<Object> failed(){
        return new Result<>(ResultEnum.COMMON_FAILED.getCode(), ResultEnum.COMMON_FAILED.getMessage(), null);
    }

    /**
     *
     * @param message 返回消息
     * @return {@link Result<Object>}
     * @author Heisenberg
     * @date 2024/2/28 21:50
     */
    public static  Result<Object> failed(@NonNull String message){
        return new Result<>(ResultEnum.COMMON_FAILED.getCode(), message, null);
    }

    /**
     *
     * @param errorResult 失败的结果
     * @return {@link Result<Object>}
     * @author Heisenberg
     * @date 2024/2/28 21:50
     */
    public static Result<Object> failed(@NonNull IResult errorResult){
        return new Result<>(errorResult.getCode(), errorResult.getMessage(), null);
    }

    /**
     *
     * @param code 状态码
     * @param message 返回消息
     * @return {@link Result<Object>}
     * @author Heisenberg
     * @date 2024/2/28 21:50
     */
    public static Result<Object> failed(@NonNull Integer code, @NonNull String message){
        return new Result<>(code, message, null);
    }

    /**
     *
     * @param code 状态码
     * @param message 返回消息
     * @param data 返回值
     * @return {@link Result<T>}
     * @author Heisenberg
     * @date 2024/2/28 21:51
     */
    public static <T> Result<T> instance(Integer code, String message, T data){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
