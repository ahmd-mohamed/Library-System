package service;

import entity.Book;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    // Constructor Injection
    // The repository dependency is provided from outside

    // instead of creating a new object inside the service

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Add a new book to the library
    public void addBook(Book book) {

        bookRepository.save(book);

    }

    // Retrieve all books from the repository
    public List<Book> getAllBooks() {

        return bookRepository.findAll();

    }

    // Search for books by title keyword
    // Returns all books that contain the keyword in their title
    public List<Book> searchByTitle(String keyword) {

        List<Book> result = new ArrayList<>();

        // Loop through all stored books
        for (Book book : bookRepository.findAll()) {

            // Case-insensitive title matching
            if (book.getTitle()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {

                result.add(book);
            }
        }

        return result;
    }

    // Find a specific book using its unique ID
    // Returns the book if found, otherwise returns null
    public Book getBookById(int id) {

        for (Book book : bookRepository.findAll()) {

            if (book.getId() == id) {

                return book;
            }
        }

        return null;
    }

    // Delete a book from the library using its ID
    public void deleteBook(int id) {

        Book book = getBookById(id);

        // Check if the book exists before deleting
        if (book != null) {

            bookRepository.delete(book);
        }
    }

    // Update existing book information
    // Returns true if update succeeds, false if book is not found
    public boolean updateBook(Book updatedBook) {

        Book existingBook = getBookById(updatedBook.getId());

        if (existingBook != null) {

            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setPublicationYear(updatedBook.getPublicationYear());
            existingBook.setStatus(updatedBook.getStatus());

            return true;
        }

        return false;
    }
}