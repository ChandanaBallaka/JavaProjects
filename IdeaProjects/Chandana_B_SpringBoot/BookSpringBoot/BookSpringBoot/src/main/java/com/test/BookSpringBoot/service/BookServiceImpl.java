package com.test.BookSpringBoot.service;

import com.test.BookSpringBoot.modal.Book;
import org.springframework.stereotype.Service;

import java.util.HashSet;
@Service
public class BookServiceImpl implements BookService
{
    HashSet<Book> bookList = new HashSet<Book>();
    public HashSet<Book> findAll()
    {
        if(bookList.isEmpty())
        {
            return null;
        }
        else {
            return bookList;
        }
    }

    @Override
    public Book findBookByID(long id) {
        Book book = bookList.stream().filter(b -> b.getId() == id).findAny().orElse(null);
        return book;
    }
    public void addBook(Book b)
    {
        bookList.add(b);
    }
    public void deleteAllData()
    {
        bookList.clear();
    }


}
