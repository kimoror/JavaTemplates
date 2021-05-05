package com.practice19.controllers;

import com.practice19.models.entities.User;
import com.practice19.security.UserDetailsServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class RegistrationController {
    final UserDetailsServiceImpl userDetailsService;

    public RegistrationController(UserDetailsServiceImpl userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public void registration(User user){
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setFirst_name(user.getFirst_name());
        newUser.setLast_name(user.getLast_name());
        System.out.println(newUser.getEmail());
        System.out.println(newUser.getRole());
        userDetailsService.addNewUser(newUser);

    }
}
