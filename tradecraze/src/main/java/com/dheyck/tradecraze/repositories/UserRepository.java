package com.dheyck.tradecraze.repositories;

import com.dheyck.tradecraze.domain.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {


}
