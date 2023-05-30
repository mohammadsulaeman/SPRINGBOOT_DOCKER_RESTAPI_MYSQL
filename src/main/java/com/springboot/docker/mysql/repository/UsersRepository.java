package com.springboot.docker.mysql.repository;

import com.springboot.docker.mysql.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
