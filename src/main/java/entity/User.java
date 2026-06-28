package entity;

import enums.Role;

public abstract class User {

    protected int id;
    protected String name;
    protected String email;
    protected String username;
    protected String password;
    protected Role role;


    public User(int id,
                String name,
                String email,
                String username,
                String password,
                Role role) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }


   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @Override
public String toString() {

    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", username='" + username + '\'' +
            ", role=" + role +
            '}';

}
}