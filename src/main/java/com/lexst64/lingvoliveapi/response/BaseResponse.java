package com.lexst64.lingvoliveapi.response;

public abstract class BaseResponse {
    protected boolean isOk;
    protected int code;
    protected String message;

    public BaseResponse setOk(boolean ok) {
        isOk = ok;
        return this;
    }

    public BaseResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public BaseResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public boolean isOk() {
        return isOk;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
