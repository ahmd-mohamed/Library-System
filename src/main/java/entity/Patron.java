package entity;

import enums.Role;

public class Patron extends User {


    public Patron(int id, String name, String email,
                  String username, String password) {

        super(id, name, email, username, password, Role.PATRON);
    }
}