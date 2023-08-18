package com.hoaxify.ws.service;

import com.hoaxify.ws.model.User;
import com.hoaxify.ws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    PasswordEncoder passwordEncoder;
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder= new BCryptPasswordEncoder();
    }

    public void save(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));//userden aldığı password encrypted yani şifreli olarak değişti
        userRepository.save(user);
    }
}
