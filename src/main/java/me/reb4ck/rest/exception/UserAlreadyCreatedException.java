package me.reb4ck.rest.exception;

public final class UserAlreadyCreatedException extends RuntimeException{
    public UserAlreadyCreatedException(String message) {
        super(message);
    }
}
