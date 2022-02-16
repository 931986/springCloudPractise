package com.SpringCloud.exception;


import com.SpringCloud.base.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 乐心湖
 * @date 2020/7/2 20:08
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class DetectException extends RuntimeException{

    //状态码
    private Integer code;

    /**
     * 接受状态码和消息
     * @param code
     * @param message
     */
    public DetectException(Integer code, String message) {
        super(message);
        this.setCode(code);
    }

    /**
     * 接收枚举类型
     * @param resultCodeEnum
     */
//    public DetectExceptionn(ResultCodeEnum resultCodeEnum) {
//        super(resultCodeEnum.getMessage());
//        this.setCode(resultCodeEnum.getCode());
//    }

    public DetectException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.setCode(resultCodeEnum.getCode());
    }

    @Override
    public String toString() {
        return "CollegeException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}

