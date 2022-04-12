package ru.netology.authorizationservice.exception;

/**
 * @author Viktor_Loskutov
 */
public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        super(msg);
    }
}