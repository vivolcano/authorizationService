package ru.netology.authorizationservice.service;

import static java.util.Objects.isNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.netology.authorizationservice.entity.Authorities;
import ru.netology.authorizationservice.exception.InvalidCredentials;
import ru.netology.authorizationservice.exception.UnauthorizedUser;
import ru.netology.authorizationservice.repository.UserRepository;

import java.util.Set;

/**
 * @author Viktor_Loskutov
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Service
public class AuthorizationService {
    UserRepository userRepository;

    public Set<Authorities> getAuthorities(String user, String password) {

        Set<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);

        if (isNull(userAuthorities)) {
            throw new InvalidCredentials("User does not exits: " + user);

        } else if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unauthorized user or password incorrect: " + user);
        }

        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(Set<?> str) {
        return str == null || str.isEmpty();
    }
}