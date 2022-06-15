package com.pollutionapp.user.service;

import com.pollutionapp.user.model.User;
import com.pollutionapp.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findById(email);
    }

    @Override
    public User updatePassword(User user,String password) {
        user.setPassword(password);
        return  userRepository.save(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
