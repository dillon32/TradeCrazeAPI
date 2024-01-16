package com.dheyck.tradecraze.tradecraze;

import com.dheyck.tradecraze.domain.entities.UserEntity;

public final class TestDataUtil {

    private TestDataUtil() {
    }

    public static UserEntity createTestUser() {
        return UserEntity.builder()
                .id(1L)
                .username("test_user")
                .password("password")
                .build();
    }
}
