package com.joshua.mingstagram.domain.user.repository;

import com.joshua.mingstagram.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
