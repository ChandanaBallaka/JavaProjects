package com.robosoft;

import java.util.ArrayList;
import java.util.List;

public  class Clerk
    {
       List<Book> books = new ArrayList<Book>();
        List<Borrower> borrowers = new ArrayList<Borrower>();
       public Clerk(){

       }

        public void searchBook(String bookName)
            {
                for(Book b : books)
                {
                    if(bookName == b.getBookName()){

                        System.out.println(bookName);

                    }
                }
            }


        public void loanHistory()
            {

            }
        public void addBorrower()
             {
                 System.out.println("Add the borrower name");
                 Borrower b1 = new Borrower("Chandana") ;
                 borrowers.add(b1);
             }
        public void borrowerRecord()
            {

            }
    }
