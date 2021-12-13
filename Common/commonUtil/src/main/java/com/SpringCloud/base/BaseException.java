package com.SpringCloud.base;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
//自己重写对象和方法
public class BaseException extends RuntimeException {
    private  int code;
    public BaseException(String message, Integer code){
super(message);
this.setCode(code);
    }
    public BaseException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.setCode(resultCodeEnum.getCode());
    }
    @Override
    public  String toString(){
        return "BaseExcetion"+"code:"+code+", "
                +"message:"+this.getMessage();
    }

//    @Override
//    public String toString() {
//        return "CollegeException{" +
//                "code=" + code +
//                ", message=" + this.getMessage() +
//                '}';
//    }
}
