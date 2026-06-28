package entity;

import java.time.LocalDate;

public class BorrowRecord {


    private int id;

    private Patron patron;

    private Book book;

    private LocalDate borrowDate;

    private LocalDate dueDate;

    private LocalDate returnDate;



    // Constructor

    public BorrowRecord(int id,
                        Patron patron,
                        Book book,
                        LocalDate borrowDate,
                        LocalDate dueDate) {

        this.id = id;
        this.patron = patron;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;

    }



    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Patron getPatron() {
        return patron;
    }


    public void setPatron(Patron patron) {
        this.patron = patron;
    }


    public Book getBook() {
        return book;
    }


    public void setBook(Book book) {
        this.book = book;
    }


    public LocalDate getBorrowDate() {
        return borrowDate;
    }


    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }


    public LocalDate getDueDate() {
        return dueDate;
    }


    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


    public LocalDate getReturnDate() {
        return returnDate;
    }


    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }



    @Override
    public String toString() {

        return "BorrowRecord{" +
                "id=" + id +
                ", patron=" + patron.getName() +
                ", book=" + book.getTitle() +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                '}';

    }

}