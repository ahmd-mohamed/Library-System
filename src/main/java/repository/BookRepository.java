package repository;

import java.util.ArrayList;
import java.util.List;

import entity.Book;

public class BookRepository {


    private List<Book> books;



    public BookRepository() {

        books = new ArrayList<>();

    }



    // Save new book
    public void save(Book book) {

        books.add(book);

    }




    // Get all books
    public List<Book> findAll() {

        return new ArrayList<>(books);

    }




    // Find book by ID
    public Book findById(int id) {


        for(Book book : books) {


            if(book.getId() == id) {

                return book;

            }

        }


        return null;

    }




    // Delete book
    public void delete(Book book) {

        books.remove(book);

    }

}