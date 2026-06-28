package entity;
import enums.*;
public class Book {

  // 🔹 Unique identifier for the book
    private int id;

    // 🔹 Book title
    private String title;

    // 🔹 Author name
    private String author;

    // 🔹 Category or genre of the book
    private String genre;

    // 🔹 Year of publication
    private int publicationYear;

    // 🔹 Current status of the book (AVAILABLE, CHECKED_OUT, RESERVED)
    private BookStatus status;


    // =========================
    // Constructors
    // =========================

    public Book() {
        // Default constructor (needed sometimes for frameworks or flexibility)
    }

    public Book(int id, String title, String author,
                String genre, int publicationYear,
                BookStatus status) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.status = status;
    }


    // =========================
    // Getters & Setters
    // =========================

    // 🔹 Get book ID
    public int getId() {
        return id;
    }

    // 🔹 Set book ID
    public void setId(int id) {
        this.id = id;
    }

    // 🔹 Get title
    public String getTitle() {
        return title;
    }

    // 🔹 Set title
    public void setTitle(String title) {
        this.title = title;
    }

    // 🔹 Get author
    public String getAuthor() {
        return author;
    }

    // 🔹 Set author
    public void setAuthor(String author) {
        this.author = author;
    }

    // 🔹 Get genre
    public String getGenre() {
        return genre;
    }

    // 🔹 Set genre
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // 🔹 Get publication year
    public int getPublicationYear() {
        return publicationYear;
    }

    // 🔹 Set publication year
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // 🔹 Get book status
    public BookStatus getStatus() {
        return status;
    }

    // 🔹 Set book status
    public void setStatus(BookStatus status) {
        this.status = status;
    }


    // =========================
    // Utility Methods
    // =========================

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + publicationYear +
                ", status=" + status +
                '}';
}
}