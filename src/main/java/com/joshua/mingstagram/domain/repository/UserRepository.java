package com.joshua.mingstagram.domain.repository;

import com.joshua.mingstagram.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
