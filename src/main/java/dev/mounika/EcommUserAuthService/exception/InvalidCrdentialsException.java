package dev.mounika.EcommUserAuthService.exception;

public class InvalidCrdentialsException extends RuntimeException {
    public InvalidCrdentialsException(String message) {
        super(message);
    }
}
