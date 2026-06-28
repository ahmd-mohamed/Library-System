package service;

import entity.User;

public class AuthService {


    private UserService userService;


    // Constructor Injection
    public AuthService(UserService userService) {

        this.userService = userService;

    }



    // Login method
    public User login(String username, String password) {


        // Find user by username
        User user = userService.findByUsername(username);



        // User does not exist
        if(user == null) {

            return null;

        }



        // Check password
        if(user.getPassword().equals(password)) {

            return user;

        }



        // Wrong password
        return null;

    }

}