package com.robosoft;

import java.util.ArrayList;
import java.util.List;

public class Borrower implements User
    {
        String name;
        float loan = 10000;
        List<Book> books = new ArrayList<Book>();

        public Borrower(String name) {
            this.name = name;
        }

        public Borrower() {

        }

        @Override
        public void searchBook(String bookName)
            {
                for(Book b : books)
                {
                    if(bookName == b.getBookName()){

                        System.out.println(bookName);

                    }
                }
             }

        @Override
        public void loanHistory()
            {

            }
        public void loanRequest()
            {

            }

    }
