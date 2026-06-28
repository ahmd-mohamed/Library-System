package service;

import entity.Book;
import entity.BorrowRecord;
import entity.Patron;

import enums.BookStatus;

import repository.BorrowRepository;

import java.time.LocalDate;
import java.util.List;


public class BorrowService {


    private BorrowRepository borrowRepository;

    // Temporary ID generator
    // Later Database will handle IDs
    private int nextRecordId = 1;



    // Constructor Injection
    public BorrowService(BorrowRepository borrowRepository) {

        this.borrowRepository = borrowRepository;

    }




    // Borrow a book
    public boolean borrowBook(Patron patron, Book book) {


        // Validate input
        if(patron == null || book == null) {

            return false;

        }



        // Check book availability

        if(book.getStatus() != BookStatus.AVAILABLE) {

            return false;

        }



        // Change book status

        book.setStatus(BookStatus.CHECKED_OUT);




        // Create borrow record

        BorrowRecord record = new BorrowRecord(

                nextRecordId++,
                patron,
                book,
                LocalDate.now(),
                LocalDate.now().plusDays(7)

        );



        // Save record

        borrowRepository.save(record);



        return true;

    }





    // Return book

    public boolean returnBook(BorrowRecord record) {


        if(record == null) {

            return false;

        }



        record.getBook()
                .setStatus(BookStatus.AVAILABLE);



        record.setReturnDate(LocalDate.now());


        return true;

    }





    // Get all borrow records

    public List<BorrowRecord> getAllRecords() {

        return borrowRepository.findAll();

    }


}