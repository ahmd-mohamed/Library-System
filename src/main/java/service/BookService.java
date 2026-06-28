package service;

import entity.Book;
import entity.User;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.List;


public class BookService {

    private BookRepository bookRepository;
    private AuthorizationService authorizationService;


    public BookService(
            BookRepository bookRepository,
            AuthorizationService authorizationService
    ) {

        this.bookRepository = bookRepository;
        this.authorizationService = authorizationService;

    }



    public boolean addBook(User user, Book book) {


        if(!authorizationService.canManageBooks(user)) {

            return false;

        }


        bookRepository.save(book);

        return true;

    }



    public List<Book> getAllBooks() {

        return bookRepository.findAll();

    }



    public List<Book> searchByTitle(String keyword) {


        List<Book> result = new ArrayList<>();


        for(Book book : bookRepository.findAll()) {


            if(book.getTitle()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {


                result.add(book);

            }

        }


        return result;

    }



    public Book getBookById(int id) {


        for(Book book : bookRepository.findAll()) {


            if(book.getId() == id) {

                return book;

            }

        }


        return null;

    }



    public boolean deleteBook(int id) {


        Book book = getBookById(id);


        if(book != null) {


            bookRepository.delete(book);

            return true;

        }


        return false;

    }



    public boolean updateBook(Book updatedBook) {


        Book existingBook =
                getBookById(updatedBook.getId());


        if(existingBook != null) {


            existingBook.setTitle(updatedBook.getTitle());

            existingBook.setAuthor(updatedBook.getAuthor());

            existingBook.setGenre(updatedBook.getGenre());

            existingBook.setPublicationYear(
                    updatedBook.getPublicationYear()
            );

            existingBook.setStatus(
                    updatedBook.getStatus()
            );


            return true;

        }


        return false;

    }

}