package com.lanceolata.code.snippets.common.domain.factory;

import com.lanceolata.code.snippets.common.domain.User;

/**
 * User工厂类
 */
public interface UserFactory {
    default User createUser() {
        return User.createUser();
    }
}
