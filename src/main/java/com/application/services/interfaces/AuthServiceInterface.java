package com.application.services.interfaces;


public interface AuthServiceInterface {

    Boolean isLoggedIn(String email, String password, String role);

}
