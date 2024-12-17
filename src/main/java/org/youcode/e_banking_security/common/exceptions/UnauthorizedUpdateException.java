package org.youcode.e_banking_security.common.exceptions;

public class UnauthorizedUpdateException extends RuntimeException {
    public UnauthorizedUpdateException(String message) {
        super(message);
    }
}
