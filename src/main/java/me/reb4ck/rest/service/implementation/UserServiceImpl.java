package me.reb4ck.rest.service.implementation;

import me.reb4ck.rest.model.User;
import me.reb4ck.rest.repository.UserRepository;
import me.reb4ck.rest.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return findAll().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    @Transactional
    public User save(User auto) {
        return repository.save(auto);
    }
}
