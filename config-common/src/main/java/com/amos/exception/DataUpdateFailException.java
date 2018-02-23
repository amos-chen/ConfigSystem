package com.amos.exception;

/**
 * Created by ${chenlunwei} on 2017/5/12.
 */
public class DataUpdateFailException extends ConfigException {

    public DataUpdateFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataUpdateFailException(String message) {
        super(message);
    }
}
