package com.amos.exception;

/**
 * Created by ${chenlunwei} on 2017/5/12.
 */
public class DataNotFindException extends ConfigException {

    public DataNotFindException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotFindException(String message) {
        super(message);
    }
}
