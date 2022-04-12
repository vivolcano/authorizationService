package ru.netology.authorizationservice.exception;

/**
 * @author Viktor_Loskutov
 */
public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        super(msg);
    }
}