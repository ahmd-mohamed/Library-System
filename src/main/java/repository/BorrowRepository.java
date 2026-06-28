package repository;

import entity.BorrowRecord;

import java.util.ArrayList;
import java.util.List;

public class BorrowRepository {


    private List<BorrowRecord> records;



    public BorrowRepository() {

        records = new ArrayList<>();

    }




    // Save borrow record
    public void save(BorrowRecord record) {

        records.add(record);

    }




    // Get all records
 public List<BorrowRecord> findAll(){

    return new ArrayList<>(records);

}




    // Find record by ID
    public BorrowRecord findById(int id) {


        for(BorrowRecord record : records) {


            if(record.getId() == id) {

                return record;

            }

        }


        return null;

    }

}