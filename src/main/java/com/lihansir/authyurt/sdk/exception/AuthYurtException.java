package com.lihansir.authyurt.sdk.exception;

/**
 * 异常
 *
 * @author <a href="https://www.lihansir.com">Li Han</a>
 */
public class AuthYurtException extends RuntimeException {

    private static final long serialVersionUID = -7835624244010031366L;

    private String errorCode;

    private String errorMessage;

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public AuthYurtException(String errorMessage) {
       this("sdk error", errorMessage);
    }

    public AuthYurtException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
