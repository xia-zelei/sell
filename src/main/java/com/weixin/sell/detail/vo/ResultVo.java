package com.weixin.sell.detail.vo;

import lombok.Data;

@Data
public class ResultVo<T> {

    /**错误代码*/
    private Integer code;

//    错误提示
    private String msg;

    private T data;

}
