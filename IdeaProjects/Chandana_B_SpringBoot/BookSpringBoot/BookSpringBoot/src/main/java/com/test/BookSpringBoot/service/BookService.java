package com.test.BookSpringBoot.service;

import com.test.BookSpringBoot.modal.Book;

import java.util.HashSet;

public interface BookService
{
    HashSet<Book> findAll();
    Book findBookByID(long id);
    void addBook(Book b);
    void deleteAllData();
}
