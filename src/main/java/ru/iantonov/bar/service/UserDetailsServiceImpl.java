package ru.iantonov.bar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.iantonov.bar.model.domain.User;
import ru.iantonov.bar.model.domain.UserDetailsAdapter;
import ru.iantonov.bar.repository.UserRepository;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByLogin(s);
        if (!optionalUser.isPresent()){
            throw new UsernameNotFoundException(s);
        }
        return new UserDetailsAdapter(optionalUser.get());
    }
}