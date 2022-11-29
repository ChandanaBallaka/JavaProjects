package springcasestudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clerk implements User
{
	int id=100;
	String name="Jenny";
	BooksBorrowed booksBorrowed;
	Borrower borrower;
	
	Clerk()
	{
		
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
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
			for(int i=0;i<n;i++)
			{
				if(id == booksBorrowedList.get(i).borrower_id)
				{
					System.out.println("Borrower id:"+booksBorrowedList.get(i).borrower_id+" Borrower name:"+booksBorrowedList.get(i).book_name+" Book id:"+booksBorrowedList.get(i).book_id);
				}
				
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
	public void add_borrower(List<Borrower> borrowerList)
	{
		System.out.println("Enter the number of borrowers to add");
		Scanner intsc = new Scanner(System.in);
		Scanner stringsc = new Scanner(System.in);
		int n = intsc.nextInt();
		for(int i=0; i<n; i++)
		{
			System.out.println("Enter the borrower id, name and id of the book they borrowed:");
			int borrower_id = intsc.nextInt();
			String borrower_name = stringsc.next();
			borrowerList.add(new Borrower(borrower_id,borrower_name));
		}
	}
	public void record_fine()
	{
		
	}
	
}
