package org.example.book_my_show.services;

import org.example.book_my_show.exceptions.UserNotFoundException;
import org.example.book_my_show.models.User;
import org.example.book_my_show.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User signUp(String name,
                       String email,
                       String password) throws UserNotFoundException {

        Optional<User> optionalUser = userRepository.findByEmail(email);
        User savedUser = null;

        if (optionalUser.isPresent()) {
            //Move to login workflow.
        } else {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            savedUser = userRepository.save(user);
        }
        return savedUser;
    }
}
