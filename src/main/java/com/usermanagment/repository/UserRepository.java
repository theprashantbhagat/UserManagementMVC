package com.usermanagment.repository;

import com.usermanagment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {



}
