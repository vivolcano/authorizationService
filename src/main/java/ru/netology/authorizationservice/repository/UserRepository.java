package ru.netology.authorizationservice.repository;

import static java.util.Collections.emptySet;
import static ru.netology.authorizationservice.entity.Authorities.DELETE;
import static ru.netology.authorizationservice.entity.Authorities.READ;
import static ru.netology.authorizationservice.entity.Authorities.WRITE;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.entity.Authorities;

import java.util.*;

/**
 * @author Viktor_Loskutov
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Repository
public class UserRepository {

    Map<String, User> users = Map.of(
        "user", new User("user", Set.of(READ, WRITE)),
        "admin", new User("admin", Set.of(READ, WRITE, DELETE))
    );

    public Set<Authorities> getUserAuthorities(String user, String password) {

        if (users.containsKey(user)) {
            return users.get(user).getPassword().equals(password) ? users.get(user).getAuthorities() : emptySet();
        }
        return null;
    }

    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    @Getter
    private static class User {
        String password;
        Set<Authorities> authorities;
    }
}