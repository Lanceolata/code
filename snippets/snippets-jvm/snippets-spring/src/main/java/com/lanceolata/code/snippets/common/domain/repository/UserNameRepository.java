package com.lanceolata.code.snippets.common.domain.repository;

import com.lanceolata.code.snippets.common.domain.User;

import java.util.Collection;

/**
 * 用户信息仓库-名称
 */
public class UserNameRepository {

    // 自定义 Bean
    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
