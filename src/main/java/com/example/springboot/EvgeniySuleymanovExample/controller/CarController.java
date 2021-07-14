package com.example.springboot.EvgeniySuleymanovExample.controller;


import com.example.springboot.EvgeniySuleymanovExample.model.Car;
import com.example.springboot.EvgeniySuleymanovExample.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("cars")
    public String findAll(Model model){
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "cars";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        carService.deleteById(id);
        return "redirect:/cars";
    }

    @GetMapping("add")
    public String addCarForm(Car car){
        return "add";
    }

    @PostMapping("car-add")
    public String addCar(Car car){
        carService.add(car);
        return "redirect:/cars";
    }

    @GetMapping("car-edit/{id}")
    public String editCarForm(@PathVariable("id") int id, Model model){
        model.addAttribute("car", carService.findById(id));
        return "car-edit";
    }

    @PostMapping("car-edit")
    public String editcar(Car car){
        carService.carEdit(car);
        return "redirect:/cars";
    }




}
