package com.aloneness.compusHelpSystem.dto;

import java.io.Serializable;

public class BaseResult implements Serializable {

    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    private int status;
    private String message;

    public static BaseResult success(){
        return BaseResult.createResult(STATUS_SUCCESS,"成功");
    }

    public static BaseResult success(String message){
        return BaseResult.createResult(STATUS_SUCCESS,message);
    }

    public static BaseResult fail(){
        return BaseResult.createResult(STATUS_FAIL,"失败");
    }
    public static BaseResult fail(String message){
        return BaseResult.createResult(STATUS_FAIL,message);
    }

    public static BaseResult fail(int status, String message){
        return BaseResult.createResult(status,message);
    }

    private static BaseResult createResult(int status,String message){
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
