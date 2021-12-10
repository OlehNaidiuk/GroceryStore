package com.naidiuk.error;

public class SerializationException extends RuntimeException {

    public SerializationException() {
    }

    public SerializationException(String message) {
        super(message);
    }
}
