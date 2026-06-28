package main;


import entity.Admin;
import entity.Book;
import entity.Librarian;
import entity.Patron;
import entity.User;
import entity.BorrowRecord;


import enums.BookStatus;


import repository.BookRepository;
import repository.UserRepository;
import repository.BorrowRepository;


import service.BookService;
import service.UserService;
import service.AuthService;
import service.BorrowService;



public class Main {


    public static void main(String[] args) {



        System.out.println("Welcome to Library Management System");




        /*
         * ==========================
         * BOOK MODULE
         * ==========================
         */


        BookRepository bookRepository =
                new BookRepository();



        BookService bookService =
                new BookService(bookRepository);




        Book book1 = new Book(

                1,
                "Clean Code",
                "Robert Martin",
                "Programming",
                2008,
                BookStatus.AVAILABLE

        );



        Book book2 = new Book(

                2,
                "Java Programming",
                "James Gosling",
                "Programming",
                2015,
                BookStatus.AVAILABLE

        );



        bookService.addBook(book1);

        bookService.addBook(book2);





        System.out.println("\nAll Books:");

        for(Book book : bookService.getAllBooks()) {

            System.out.println(book);

        }





        /*
         * ==========================
         * USER MODULE
         * ==========================
         */


        UserRepository userRepository =
                new UserRepository();




        UserService userService =
                new UserService(userRepository);




        AuthService authService =
                new AuthService(userService);





        Admin admin = new Admin(

                1,
                "Ahmed Admin",
                "admin@gmail.com",
                "admin",
                "1234"

        );




        Librarian librarian = new Librarian(

                2,
                "Ali Librarian",
                "librarian@gmail.com",
                "ali",
                "1234"

        );





        Patron patron = new Patron(

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
         * ==========================
         * AUTHENTICATION TEST
         * ==========================
         */


        System.out.println("\nLogin Test:");



        User loggedUser =
                authService.login(
                        "admin",
                        "1234"
                );




        if(loggedUser != null) {


            System.out.println("Login Successful");

            System.out.println(loggedUser);


        }
        else {


            System.out.println("Invalid username or password");


        }







        /*
         * ==========================
         * BORROW MODULE
         * ==========================
         */



        BorrowRepository borrowRepository =
                new BorrowRepository();




        BorrowService borrowService =
                new BorrowService(borrowRepository);






        System.out.println("\nBefore Borrow:");

        System.out.println(book1);





        boolean borrowed =
                borrowService.borrowBook(
                        patron,
                        book1
                );




        System.out.println("\nBorrow Result: " + borrowed);





        System.out.println("\nAfter Borrow:");

        System.out.println(book1);







        /*
         * ==========================
         * BORROW RECORDS
         * ==========================
         */



        System.out.println("\nBorrow Records:");



        for(BorrowRecord record :
                borrowService.getAllRecords()) {


            System.out.println(record);


        }








        /*
         * ==========================
         * RETURN BOOK
         * ==========================
         */



        BorrowRecord record =
                borrowService
                        .getAllRecords()
                        .get(0);




        boolean returned =
                borrowService.returnBook(record);





        System.out.println("\nReturn Result: " + returned);





        System.out.println("\nAfter Return:");

        System.out.println(book1);







        System.out.println("\nBorrow Records After Return:");



        for(BorrowRecord borrowRecord :
                borrowService.getAllRecords()) {


            System.out.println(borrowRecord);


        }




    }

}