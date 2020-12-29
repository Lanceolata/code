package com.lanceolata.code.snippets.common.java.exception;

public class JsonException extends Exception {
    public JsonException(String message) {
        super(message);
    }

    public JsonException(String message, Throwable cause) {
        super(message, cause);
    }
}
