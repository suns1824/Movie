package com.movie.model.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -554753474580157773L;
    private boolean           success          = true;
    private String            errorCode;
    private String            errorMessage;
    private T                 model;

    public Result() {
    }

    public Result(ResultCode resultCode) {
        this.success = false;
        this.errorCode = resultCode.getErrorCode();
        this.errorMessage = resultCode.getErrorMessage();
    }

    public void withResultCode(ResultCode resultCode) {
        this.success = false;
        this.errorCode = resultCode.getErrorCode();
        this.errorMessage = resultCode.getErrorMessage();
    }

}
