package main;

import entity.Admin;
import entity.Book;
import entity.BorrowRecord;
import entity.Librarian;
import entity.Patron;
import entity.User;

import enums.BookStatus;

import repository.BookRepository;
import repository.UserRepository;
import repository.BorrowRepository;

import service.AuthService;
import service.AuthorizationService;
import service.BookService;
import service.UserService;
import service.BorrowService;


public class Main {

    public static void main(String[] args) {


        System.out.println("Welcome to Library Management System");



        /*
         * ===========================
         * REPOSITORIES
         * ===========================
         */

        BookRepository bookRepository =
                new BookRepository();


        UserRepository userRepository =
                new UserRepository();


        BorrowRepository borrowRepository =
                new BorrowRepository();




        /*
         * ===========================
         * SERVICES
         * ===========================
         */


        AuthorizationService authorizationService =
                new AuthorizationService();



        BookService bookService =
                new BookService(
                        bookRepository,
                        authorizationService
                );



        UserService userService =
                new UserService(
                        userRepository
                );



        AuthService authService =
                new AuthService(
                        userService
                );



        BorrowService borrowService =
                new BorrowService(
                        borrowRepository
                );






        /*
         * ===========================
         * USERS
         * ===========================
         */


        Admin admin =
                new Admin(
                        1,
                        "Ahmed Admin",
                        "admin@gmail.com",
                        "admin",
                        "1234"
                );



        Librarian librarian =
                new Librarian(
                        2,
                        "Ali Librarian",
                        "librarian@gmail.com",
                        "ali",
                        "1234"
                );



        Patron patron =
                new Patron(
                        3,
                        "Mohamed Patron",
                        "patron@gmail.com",
                        "mohamed",
                        "1234"
                );



        userService.addUser(admin);
        userService.addUser(librarian);
        userService.addUser(patron);




        System.out.println("\nAll Users:");

        for(User user : userService.getAllUsers()) {

            System.out.println(user);

        }





        /*
         * ===========================
         * LOGIN TEST
         * ===========================
         */


        System.out.println("\nLogin Test:");

        User loggedUser =
                authService.login(
                        "mohamed",
                        "1234"
                );



        if(loggedUser != null) {

            System.out.println("Login Successful");
            System.out.println(loggedUser);

        }
        else {

            System.out.println("Login Failed");

        }





        /*
         * ===========================
         * BOOK TEST
         * ===========================
         */


        Book book1 =
                new Book(
                        1,
                        "Clean Code",
                        "Robert Martin",
                        "Programming",
                        2008,
                        BookStatus.AVAILABLE
                );



        Book book2 =
                new Book(
                        2,
                        "Java Programming",
                        "James Gosling",
                        "Programming",
                        2015,
                        BookStatus.AVAILABLE
                );




        System.out.println("\nAdd Book By Admin:");

        System.out.println(
                bookService.addBook(
                        admin,
                        book1
                )
        );




        System.out.println("\nAdd Book By Patron:");

        System.out.println(
                bookService.addBook(
                        patron,
                        book2
                )
        );






        System.out.println("\nAll Books:");

        for(Book book : bookService.getAllBooks()) {

            System.out.println(book);

        }





        /*
         * ===========================
         * SEARCH TEST
         * ===========================
         */


        System.out.println("\nSearch Result:");

        for(Book book :
                bookService.searchByTitle("Clean")) {


            System.out.println(book);

        }







        /*
         * ===========================
         * BORROW TEST
         * ===========================
         */


        System.out.println("\nBefore Borrow:");

        System.out.println(book1);



        boolean borrowed =
                borrowService.borrowBook(
                        patron,
                        book1
                );



        System.out.println(
                "\nBorrow Result: "
                + borrowed
        );



        System.out.println("\nAfter Borrow:");

        System.out.println(book1);







        /*
         * ===========================
         * BORROW RECORDS
         * ===========================
         */


        System.out.println("\nBorrow Records:");

        for(BorrowRecord record :
                borrowService.getAllRecords()) {


            System.out.println(record);

        }








        /*
         * ===========================
         * RETURN TEST
         * ===========================
         */


        BorrowRecord record =
                borrowService
                        .getAllRecords()
                        .get(0);




        boolean returned =
                borrowService.returnBook(record);




        System.out.println(
                "\nReturn Result: "
                + returned
        );




        System.out.println("\nAfter Return:");

        System.out.println(book1);





        System.out.println("\nBorrow Records After Return:");

        for(BorrowRecord borrowRecord :
                borrowService.getAllRecords()) {


            System.out.println(borrowRecord);

        }






        /*
         * ===========================
         * DELETE TEST
         * ===========================
         */


        System.out.println("\nDelete Book Test:");

        boolean deleted =
                bookService.deleteBook(
                        book1.getId()
                );



        System.out.println(
                "Delete Result: "
                + deleted
        );




        System.out.println("\nBooks After Delete:");

        for(Book book :
                bookService.getAllBooks()) {


            System.out.println(book);

        }




        System.out.println(
                "\nSystem Test Finished Successfully"
        );

    }

}