package com.dheyck.tradecraze.services;
import com.dheyck.tradecraze.domain.entities.UserEntity;

import java.util.Optional;

public interface UserService {

    UserEntity createUser(UserEntity user);

    Optional<UserEntity> getUserById(Long id);
}
