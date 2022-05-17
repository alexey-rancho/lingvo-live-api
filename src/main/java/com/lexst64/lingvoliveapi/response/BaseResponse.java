package com.lexst64.lingvoliveapi.response;

public abstract class BaseResponse {

    protected boolean isOk;
    protected int code;
    protected String message;
    protected String errorDescription;

    protected BaseResponse() {
        isOk = true;
        code = 200;
        message = "OK";
        errorDescription = "";
    }

    public boolean isOk() {
        return isOk;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

    public String errorDescription() {
        return errorDescription;
    }
}
