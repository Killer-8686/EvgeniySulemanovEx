package com.example.springboot.EvgeniySuleymanovExample.repository;

import com.example.springboot.EvgeniySuleymanovExample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

}
