package com.paopao.common;

import java.util.Arrays;

/**
 * 自定义错误类型
 * @author libinghui
 * @date 2018/4/10 8:31
 */
public class PaoPaoException extends RuntimeException {

    public static final String UNKNOWN_EXCEPTION = "paopao.exception.unknownException";
    public static final int ERROR_CODE_UNKNOWN = Integer.MIN_VALUE;

    private int code;
    private String[] params = null;

    public PaoPaoException(String key) {
        super(key);
        this.code = ERROR_CODE_UNKNOWN;
    }

    public PaoPaoException(String key, int code) {
        super(key);
        this.code = code;
    }

    public PaoPaoException(String key, String... params) {
        super(key);
        this.code = ERROR_CODE_UNKNOWN;
        this.params = params;
    }

    public PaoPaoException(String key, int code, String... params) {
        super(key);
        this.code = code;
        this.params = params;
    }

    public PaoPaoException(String key, Throwable cause) {
        super(key, cause);
    }

    public PaoPaoException(String key, Throwable cause, String... params) {
        super(key, cause);
        this.params = params;
    }

    public PaoPaoException(String key, int code, Throwable cause, String... params) {
        super(key, cause);
        this.code = code;
        this.params = params;
    }

    public void addParam(String... params) {
        if (this.params == null) {
            this.params = params;
        } else {
            String[] result = Arrays.copyOf(this.params, this.params.length + params.length);
            System.arraycopy(params, 0, result, this.params.length, params.length);
            this.params = result;
        }
    }

    public String[] getParams() {
        return this.params;
    }

    public int getCode() {
        return this.code;
    }

}
