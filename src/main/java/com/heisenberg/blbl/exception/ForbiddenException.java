package com.heisenberg.blbl.exception;

/**
 * @author Heisenberg
 * @date 2024-02-28 22:05:05
 * @version 1.0
 */
public class ForbiddenException extends RuntimeException{
    public ForbiddenException() {
        super();
    }

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForbiddenException(Throwable cause) {
        super(cause);
    }
}
