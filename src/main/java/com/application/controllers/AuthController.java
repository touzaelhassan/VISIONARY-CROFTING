package com.application.controllers;

import com.application.entities.LoginCredentials;
import com.application.services.interfaces.AuthServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("authControllerBean")
public class AuthController {

    private AuthServiceInterface authServiceBean;

    @Autowired
    public AuthController(AuthServiceInterface authServiceBean) { this.authServiceBean = authServiceBean; }

    @GetMapping("/")
    private String login(Model model){
        return "login";
    }

    @PostMapping("/login")
    private String login(@ModelAttribute LoginCredentials loginCredentials, Model model){

        String email = loginCredentials.getEmail();
        String password = loginCredentials.getPassword();
        String role = loginCredentials.getRole();


       if(authServiceBean.isLoggedIn(email, password, role)){

           return "redirect:/home";

       }else{

            return "redirect:/";

        }

    }

}
