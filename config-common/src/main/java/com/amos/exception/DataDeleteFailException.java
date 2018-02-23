package com.amos.exception;

/**
 * Created by ${chenlunwei} on 2017/5/12.
 */
public class DataDeleteFailException extends ConfigException {

    public DataDeleteFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataDeleteFailException(String message) {
        super(message);
    }
}
