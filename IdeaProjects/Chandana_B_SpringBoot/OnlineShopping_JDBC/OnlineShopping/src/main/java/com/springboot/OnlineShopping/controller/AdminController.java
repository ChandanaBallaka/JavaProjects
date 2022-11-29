package com.springboot.OnlineShopping.controller;


import com.springboot.OnlineShopping.entity.Book;
import com.springboot.OnlineShopping.service.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @PostMapping("/addBook1")                                                            //adding new book
    public void addBook(@RequestBody Book book)
    {
        adminRepository.addBook(book);
    }

    @GetMapping("/findall")                                                               //viewing all the books
    public List<Book> viewAllBook(){
        return adminRepository.viewAllBook();
    }


    @DeleteMapping("/book/{bookName}")                                                   //delteing book
    public String removeBook(@PathVariable String bookName)
    {
        return adminRepository.removeBook(bookName);
    }


    @PutMapping("/book1/{bookName}/{bookPrice}")                                                     //updating book
    public String updateBookAmount(@PathVariable String bookName, @PathVariable int bookPrice)
    {
        return adminRepository.updateBookAmount(bookName,bookPrice);
    }
}
