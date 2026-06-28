package service;

import entity.User;
import repository.UserRepository;

import java.util.List;

public class UserService {


    private UserRepository userRepository;


    // Constructor Injection
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;

    }



    // Add a new user
    // Returns false if username already exists
    public boolean addUser(User user) {


        if(userRepository.existsByUsername(user.getUsername())) {

            return false;

        }


        userRepository.save(user);

        return true;

    }



    // Get all users
    public List<User> getAllUsers() {

        return userRepository.findAll();

    }



    // Find user by username
    public User findByUsername(String username) {

        return userRepository.findByUsername(username);

    }



    // Find user by ID
    public User findById(int id) {

        return userRepository.findById(id);

    }



    // Delete user by ID
    public boolean deleteUser(int id) {


        User user = findById(id);


        if(user != null) {

            userRepository.delete(user);

            return true;
        }


        return false;

    }



    // Update user information
    public boolean updateUser(User updatedUser) {


        User existingUser = findById(updatedUser.getId());


        if(existingUser != null) {


            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());


            return true;
        }


        return false;

    }

}