package me.reb4ck.rest.service;

import me.reb4ck.rest.model.User;
import java.util.Optional;

public interface UserService {
    Iterable<User> findAll();

    Optional<User> findByEmail(String email);

    User save(User auto);
}
