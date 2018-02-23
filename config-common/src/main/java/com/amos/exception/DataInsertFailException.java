package com.amos.exception;

/**
 * Created by ${chenlunwei} on 2017/5/12.
 */
public class DataInsertFailException extends ConfigException {

    public DataInsertFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataInsertFailException(String message) {
        super(message);
    }
}
