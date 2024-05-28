package com.clj.common.response;

import com.clj.common.constants.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author clj
 * @create 2024/5/28 09:11
 */
@Data
@Accessors(chain = true) // 链式调用
public class ResponseResult<T extends Object> {

    private int code;
    private String message;
    private T data;

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(T data) {
        this.data = data;
    }

    public ResponseResult() {
    }

    public static <T> ResponseResult success(){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode())
                .setMessage(CommonStatusEnum.SUCCESS.getValue())
                .setData("");
    }

    public static <T> ResponseResult success(T data){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode())
                                   .setMessage(CommonStatusEnum.SUCCESS.getValue())
                                   .setData(data);
    }

    public static <T> ResponseResult fail(T data){
        return new ResponseResult().setCode(CommonStatusEnum.FAIL.getCode())
                                   .setMessage(CommonStatusEnum.FAIL.getValue())
                                   .setData(data);
    }

}
