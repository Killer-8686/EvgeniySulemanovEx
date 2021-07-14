package com.example.springboot.EvgeniySuleymanovExample.service;

;
import com.example.springboot.EvgeniySuleymanovExample.model.Car;
import com.example.springboot.EvgeniySuleymanovExample.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public void deleteById(int id){carRepository.deleteById(id);}

    public void add(Car car){carRepository.save(car);}

    public Car findById(int id){
        return carRepository.findById(id).orElse(null);
    }

    public void carEdit(Car car){carRepository.save(car);}

}
