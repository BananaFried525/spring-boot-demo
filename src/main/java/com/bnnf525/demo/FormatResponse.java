package com.bnnf525.demo;

public class FormatResponse {
    public String info;
    public Integer status;
    public Object data;

    public FormatResponse(String info, Integer status, Object data) {
        this.info = info;
        this.status = status;
        this.data = data;
    }

}
