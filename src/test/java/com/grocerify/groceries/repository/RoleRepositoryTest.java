package com.grocerify.groceries.repository;

import com.grocerify.groceries.model.Role;
import com.grocerify.groceries.model.RoleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class RoleRepositoryTest {
    @Autowired
    RoleRepository roleRepository;

    @Test
    void findByName() {
        Optional<Role> byName = roleRepository.findByName(RoleEnum.ROLE_ADMIN);
        System.out.println(byName.get());
    }
}