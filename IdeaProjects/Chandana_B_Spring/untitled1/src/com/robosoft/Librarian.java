package com.robosoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class Librarian implements User
    {
        List<Book> books ;
        Clerk clerk;
        List<Borrower> borrowers;
        Scanner sc = new Scanner(System.in);

        public Librarian() {

        }

        public void setBooks(List<Book> books) {
            this.books = books;
        }

        public void setClerk(Clerk clerk) {
            this.clerk = clerk;
        }

        public void setBorrowers(List<Borrower> borrowers) {
            this.borrowers = borrowers;
        }

        public void setSc(Scanner sc) {
            this.sc = sc;
        }

//        @Override
//        public void searchBook() {
//
//        }

        @Override
        public void searchBook(String bookName)
            {
                for(Book b : books)
                {
                    if(bookName.equalsIgnoreCase(b.getBookName())){

                        System.out.println(bookName);

                    }
                }
            }

        @Override
        public void loanHistory()
            {
                System.out.println("Enter borrower id");
                for(int i=0;i<borrowers.size();i++)

                {
                    Borrower tempObject=borrowers.get(i);
                    System.out.println("Employee name:"+tempObject.name);
                    System.out.println("Employee name:"+tempObject.loan);
                }

            }
        public void addBorrower()
            {
                System.out.println("Add the borrower name");
                Borrower b1 = new Borrower("Chandana") ;
                borrowers.add(b1);

            }
        public void addBook()
            {
                System.out.println("****Book Name****");
                Book book1 = new Book("jhj",223);
                books.add(book1);
            }
        public void deleteBook(String bookName)
            {
                for(int i = 0; i< books.size();i++)
                {
                    if(bookName == books.get(i).getBookName()){

                       books.remove(i);
                        break;

                    }
                }
            }

    }
