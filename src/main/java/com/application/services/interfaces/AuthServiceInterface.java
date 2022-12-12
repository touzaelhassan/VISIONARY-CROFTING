package com.application.services.interfaces;


import jakarta.servlet.http.HttpSession;

public interface AuthServiceInterface {

    Boolean isLoggedIn(String email, String password, String role , HttpSession httpSession);

}
