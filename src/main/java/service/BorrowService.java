package service;

import entity.Book;
import entity.BorrowRecord;
import entity.Patron;

import enums.BookStatus;

import repository.BorrowRepository;

import java.time.LocalDate;



public class BorrowService {


    private BorrowRepository borrowRepository;



    // Constructor Injection
    public BorrowService(BorrowRepository borrowRepository) {

        this.borrowRepository = borrowRepository;

    }




    // Borrow a book
    public boolean borrowBook(Patron patron, Book book) {



        // Check if book is available
        if(book.getStatus() != BookStatus.AVAILABLE) {

            return false;

        }



        // Change book status
        book.setStatus(BookStatus.CHECKED_OUT);




        // Create borrow record

        BorrowRecord record = new BorrowRecord(

                1,
                patron,
                book,
                LocalDate.now(),
                LocalDate.now().plusDays(7)

        );



        // Save record

        borrowRepository.save(record);



        return true;

    }





    // Return a book
    public boolean returnBook(BorrowRecord record) {



        if(record == null) {

            return false;

        }



        // Update book status

        record.getBook()
                .setStatus(BookStatus.AVAILABLE);



        // Set return date

        record.setReturnDate(LocalDate.now());



        return true;

    }





    // Get all borrow records

    public void getAllRecords() {


        for(BorrowRecord record : borrowRepository.findAll()) {

            System.out.println(record);

        }

    }

}