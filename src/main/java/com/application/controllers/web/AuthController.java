package com.application.controllers.web;

import com.application.entities.LoginCredentials;
import com.application.services.interfaces.AuthServiceInterface;
import jakarta.servlet.http.HttpSession;
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
    private String login(@ModelAttribute LoginCredentials loginCredentials, Model model, HttpSession httpSession){

        String email = loginCredentials.getEmail();
        String password = loginCredentials.getPassword();
        String role = loginCredentials.getRole();

        if(authServiceBean.isLoggedIn(email, password, role, httpSession)){

            return "redirect:/home";

        }else{

            return "redirect:/";

        }

    }

}
