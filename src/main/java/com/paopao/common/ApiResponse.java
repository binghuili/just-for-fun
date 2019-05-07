package com.paopao.common;

import java.util.Date;

/**
 * JSon 返回类
 *
 * @param <T>
 * @author stephen
 */
public class ApiResponse<T> {
    private boolean error = false;
    private int code;
    private String message;
    private Date timestamp;
    private T data;

    public ApiResponse() {
    }

    /**
     * @deprecated use make(message) instead
     * @param message
     */
    public ApiResponse(String message) {
        this(0, message, null);
    }

    /**
     * @param isError
     * @param code
     * @param message
     * @deprecated use make(isError,code,message) instead
     */
    public ApiResponse(boolean isError, int code, String message) {
        this(isError, code, message, null);
    }

    /**
     * @deprecated use make(data) instead
     * @param data
     */
    public ApiResponse(T data) {
        this(0, null, data);
    }

    /**
     * @deprecated use make(code,message,data) instead
     * @param code
     * @param message
     * @param data
     */
    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = new Date();
    }

    /**
     * @deprecated use make(isError,code,message,data) instead
     * @param isError
     * @param code
     * @param message
     * @param data
     */
    public ApiResponse(boolean isError, int code, String message, T data) {
        this.error = isError;
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = new Date();
    }

    public static ApiResponse make(String message) {
        return new ApiResponse(0, message, null);
    }

    public static ApiResponse make(boolean isError, int code, String message) {
        return new ApiResponse(isError, code, message, null);
    }

    public static <T> ApiResponse<T> make(T data) {
        return new ApiResponse(0, null, data);
    }

    public static <T> ApiResponse<T> make(int code, String message, T data) {
        return new ApiResponse(code, message, data);
    }

    public static <T> ApiResponse<T> make(boolean isError, int code, String message, T data) {
        return new ApiResponse(isError, code, message, data);
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
