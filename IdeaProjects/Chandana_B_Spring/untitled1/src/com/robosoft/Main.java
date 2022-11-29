package com.robosoft;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main
    {
        public static void main(String[] args)
            {
                    Librarian l = new Librarian();
                    Clerk c = new Clerk();
                    l.setClerk(c);
                     List<Book> abooks = new ArrayList<Book>();
                     Book b = new Book("Java for beginners",244);
                    abooks.add(b);
                     Book b1 = new Book("",244);
                    l.setBooks(abooks);
                ClassPathXmlApplicationContext context =
                        new ClassPathXmlApplicationContext("applicationContext.xml");


            }
    }
