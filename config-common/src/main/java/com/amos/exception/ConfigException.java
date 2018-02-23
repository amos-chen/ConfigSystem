package com.amos.exception;

/**
 * Created by ${chenlunwei} on 2017/5/12.
 */
public class ConfigException extends RuntimeException {

    public ConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigException(String message) {
        super(message);
    }
}
