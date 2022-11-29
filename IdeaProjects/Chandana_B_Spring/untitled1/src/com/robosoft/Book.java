package com.robosoft;

import java.util.HashMap;

public class Book
    {
        String bookName;
        int bookLoan;

        public Book(String bookName, int bookLoan) {
            this.bookName = bookName;
            this.bookLoan = bookLoan;
        }

        public String getBookName()
            {
                return bookName;
            }

        public void setBookName(String bookName)
            {
                this.bookName = bookName;
            }

        public int getBookLoan()
            {
                 return bookLoan;
            }

        public void setBookLoan(int bookLoan)
            {
                this.bookLoan = bookLoan;
            }
    }
