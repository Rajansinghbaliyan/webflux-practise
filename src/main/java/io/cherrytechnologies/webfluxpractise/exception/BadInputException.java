package io.cherrytechnologies.webfluxpractise.exception;

public class BadInputException extends RuntimeException{
    public BadInputException() {
        super();
    }

    public BadInputException(String message) {
        super(message);
    }

    public BadInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadInputException(Throwable cause) {
        super(cause);
    }
}
