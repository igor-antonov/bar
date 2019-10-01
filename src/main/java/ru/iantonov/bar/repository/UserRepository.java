package ru.iantonov.bar.repository;

import org.springframework.data.repository.CrudRepository;
import ru.iantonov.bar.model.domain.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByLogin(String login);
}
