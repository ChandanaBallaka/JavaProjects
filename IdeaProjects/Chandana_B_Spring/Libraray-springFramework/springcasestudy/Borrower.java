package springcasestudy;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class Borrower implements User
{
	int id;
	String name;
	BooksBorrowed booksBorrowed;
	
	Borrower(){}
	@Autowired
	Borrower(int id,String name)
	{
		this.id=id;
		this.name=name;
	}

	@Override
	public void search(List<Book> bookList) 
	{
		Scanner stringsc = new Scanner(System.in);
		System.out.println("enter the book name to search");
		String book_name = stringsc.next();
		int n = bookList.size(), flag=0;
		for(int i=0;i<n;i++)
		{
			if(book_name.equalsIgnoreCase(bookList.get(i).book_name))
			{
				System.out.println("Book id:"+bookList.get(i).id+" Book name:"+bookList.get(i).book_name+" Author:"+bookList.get(i).author);
				flag = 1;
				break;
			}
		}
		if(flag == 0)
		{
			System.out.println("No such books");
		}	
	}

	@Override
	public void loan_history(List<BooksBorrowed> booksBorrowedList) 
	{
		Scanner intsc = new Scanner(System.in);
		int n = booksBorrowedList.size();
		System.out.println("Enter the id of borrower to display");
		int id = intsc.nextInt();
		if(n!=0) 
		{
			int flag =0;
			for(int i=0;i<n;i++)
			{
				if(id == booksBorrowedList.get(i).borrower_id)
				{
					flag=1;
					System.out.println("Borrower id:"+booksBorrowedList.get(i).borrower_id+" Borrower name:"+booksBorrowedList.get(i).book_name+" Book id:"+booksBorrowedList.get(i).book_id);
				}				
			}
			if(flag==0)
			{
				System.out.println("No purchase history for id:"+id);
			}
		}
		else
		{
			System.out.println("No books has been borrowed");
		}
	}
	void display(List<Book> bookList)
	{
		int n = bookList.size();
		for(int i=0;i<n;i++)
		{
			System.out.println("Book id:"+bookList.get(i).id+" Book name:"+bookList.get(i).book_name+" Author:"+bookList.get(i).author);
		}
	}
	public void borrow(List<Book> bookList,List<BooksBorrowed> booksBorrowedList,List<Borrower> borrowerList)
	{
		System.out.println("Enter the number of books to borrow");
		Scanner intsc = new Scanner(System.in);
		Scanner stringsc = new Scanner(System.in);
		int noOfBooks = intsc.nextInt();
		for( int i=0; i<noOfBooks; i++)
		{
			System.out.println("Enter your borrower id,book name and the id of the book you want to buy.");
			int borrowerId = intsc.nextInt();
			String bookName = stringsc.next();
			int bookId = intsc.nextInt();
			for(int j=0;j<bookList.size();j++)
			{
				
				if(bookId == bookList.get(j).id)
				{
					
					booksBorrowedList.add(new BooksBorrowed(borrowerId,bookName,bookId));
					System.out.println("You borrowed a book with id:"+bookList.get(j).id+"\nName of the book is:"+bookList.get(j).book_name);
				}
			}
			
		}
	}
	public void request_loan()
	{
		
	}

}
