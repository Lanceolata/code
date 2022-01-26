package com.lanceolata.code.snippets.common.domain.factory;

import com.lanceolata.code.snippets.common.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * User Bean 的 FactoryBean 实现
 */
public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
