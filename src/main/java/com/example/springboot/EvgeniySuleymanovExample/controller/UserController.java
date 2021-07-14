package com.example.springboot.EvgeniySuleymanovExample.controller;

import com.example.springboot.EvgeniySuleymanovExample.model.User;
import com.example.springboot.EvgeniySuleymanovExample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        String change = "null";
        model.addAttribute("change", change);
        String insight = "Text from UserController, getting from Model attribute";
        model.addAttribute("insight", insight);
        return "user-list";
    }

    @GetMapping("user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteById(@PathVariable("id") int id){
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("user-update/{id}")
    public String updateUserForm(@PathVariable ("id") int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("user-update")
    public String updateUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
}
