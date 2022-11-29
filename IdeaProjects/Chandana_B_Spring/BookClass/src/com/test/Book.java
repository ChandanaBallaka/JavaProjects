package com.test;

public class Book
    {
        private String bookName;
        private int ISBNnum;
        private String authorName;
        private  String publisher;

        public Book()
            {
            }

        public Book(String bookName, int ISBNnum, String authorName, String publisher)
            {
                this.bookName = bookName;
                this.ISBNnum = ISBNnum;
                this.authorName = authorName;
                this.publisher = publisher;
            }

        public String getBookName()
            {
                return bookName;
            }
        public void setBookName(String bookName)
             {
                this.bookName = bookName;
             }

        public int getISBNnum()
            {
                return ISBNnum;
            }

        public void setISBNnum(int ISBNnum)
            {
                this.ISBNnum = ISBNnum;
            }

        public String getAuthorName()
            {
                return authorName;
            }

        public void setAuthorName(String authorName)
            {
                this.authorName = authorName;
            }

        public String getPublisher()
            {
                return publisher;
            }

        public void setPublisher(String publisher)
            {
                this.publisher = publisher;
            }
        void getBookInfo()
            {
                System.out.println(bookName + " " + ISBNnum + " " + authorName);
             }
    }
