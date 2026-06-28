package entity;

import enums.Role;

public class Admin extends User {


    public Admin(int id, String name, String email,
                 String username, String password) {

        super(id, name, email, username, password, Role.ADMIN);
    }
}