package entity;

import enums.Role;

public class Librarian extends User {

    public Librarian(int id, String name, String email,
            String username, String password) {

        super(id, name, email, username, password, Role.LIBRARIAN);
    }
}