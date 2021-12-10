package com.naidiuk.error;

public class DeserializationException extends RuntimeException {

    public DeserializationException() {
    }

    public DeserializationException(String massage) {
        super(massage);
    }
}
