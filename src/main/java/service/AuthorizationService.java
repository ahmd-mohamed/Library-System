package service;

import entity.User;
import enums.Role;


public class AuthorizationService {



    // Check if user can manage books
    // Admin and Librarian permissions

    public boolean canManageBooks(User user) {


        if(user == null) {

            return false;

        }


        return user.getRole() == Role.ADMIN
                ||
               user.getRole() == Role.LIBRARIAN;

    }





    // Check if user can borrow books
    // Only Patrons can borrow

    public boolean canBorrowBooks(User user) {


        if(user == null) {

            return false;

        }


        return user.getRole() == Role.PATRON;

    }

}