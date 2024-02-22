package com.grocerify.groceries.repository;

import com.grocerify.groceries.model.Role;
import com.grocerify.groceries.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}