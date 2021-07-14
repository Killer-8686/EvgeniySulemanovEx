package com.example.springboot.EvgeniySuleymanovExample.repository;

import com.example.springboot.EvgeniySuleymanovExample.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
