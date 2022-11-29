package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class BookClass
{
    public static void main(String[] args)
    {

        Book[] book = new Book[5];
        System.out.println("Information of books ");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        for(int i = 0; i < 2; i++)
        {
            System.out.print("Enter the title of the book ");
            String title = scanner.nextLine();
            System.out.print("Enter the ISBN number of the book ");
            int ISBN = scanner2.nextInt();
            System.out.print("Author of the book ");
            String author = scanner.nextLine();
            System.out.print("Publisher of the book ");
            String publisher = scanner.nextLine();
            book[i]=new Book(title, ISBN, author, publisher);

        }

        for(int i = 0; i < 2; i++)
        {
            book[i].getBookInfo();
        }

    }
}
