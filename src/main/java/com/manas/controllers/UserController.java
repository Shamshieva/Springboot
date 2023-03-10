package com.manas.controllers;

import com.manas.entities.User;
import com.manas.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "view_all";
    }


    @GetMapping("/new")
    public String createUpdatePage(Model model){
        model.addAttribute("user", new User());
        return "create_user";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", userService.getUserById(id));
        return "update_user";
    }

    @PatchMapping
    public String update(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/user/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return "redirect:/user/all";
    }

}
