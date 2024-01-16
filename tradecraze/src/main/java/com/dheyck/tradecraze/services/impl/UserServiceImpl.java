package com.dheyck.tradecraze.services.impl;

import com.dheyck.tradecraze.domain.entities.UserEntity;
import com.dheyck.tradecraze.repositories.UserRepository;
import com.dheyck.tradecraze.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
