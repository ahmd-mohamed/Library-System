package repository;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {


    private List<User> users;


    public UserRepository() {

        users = new ArrayList<>();

    }


    // Save a new user
    public void save(User user) {

        users.add(user);

    }


    // Return all users
    public List<User> findAll() {

        return new ArrayList<>(users);

    }


    // Find user by username
    public User findByUsername(String username) {

        for (User user : users) {

            if (user.getUsername().equals(username)) {

                return user;
            }
        }

        return null;
    }


    // Find user by ID
    public User findById(int id) {

        for (User user : users) {

            if (user.getId() == id) {

                return user;
            }
        }

        return null;
    }


    // Delete user
    public void delete(User user) {

        users.remove(user);

    }
    // Check if username already exists
public boolean existsByUsername(String username) {

    for(User user : users) {

        if(user.getUsername().equals(username)) {

            return true;
        }
    }

    return false;
}

}
