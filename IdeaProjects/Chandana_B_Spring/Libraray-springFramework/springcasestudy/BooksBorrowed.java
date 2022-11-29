package springcasestudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BooksBorrowed 
{
//	Borrower borrowerObj;
//	Book bookObj;
	int borrower_id ;
	int book_id;
	String book_name ;
	//List<BooksBorrowed> booksBorrowedList = new ArrayList<>();
	
	BooksBorrowed(int borrower_id,String book_name, int book_id)
	{
		this.borrower_id = borrower_id;
		this.book_name = book_name;
		this.book_id = book_id;
	}
}
