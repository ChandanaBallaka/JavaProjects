package springcasestudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main 
{

	public static void main(String[] args) 
	{
		
		Scanner stringsc=new Scanner(System.in);
		Scanner intsc=new Scanner(System.in);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Librarian user1 = (Librarian) context.getBean("librarian");
		Clerk user2 = (Clerk) context.getBean("clerk");
		Borrower user3 = (Borrower) context.getBean("borrower") ;
		
		List<Book> booksList = new ArrayList<Book>();
		List<BooksBorrowed> booksBorrowedList = new ArrayList<>();
		List<Borrower> borrowerList = new ArrayList<>();

		booksList.add(new Book(1111,"Java","Joshua"));
		booksList.add(new Book(2222,"Python","Jimmy"));
		booksList.add(new Book(3333,"C","Ramanujan"));

		
		String userChoice;
		do 
		{
			System.out.println("Enter your role:\n1.librarian\n2.clerk \n3.borrower");
			int choice=intsc.nextInt();
			
			switch(choice)
			{
				case 1: String libOption;
						do {	
								System.out.println("Enter your choice:\n1.Search Book\n2.View loan history\n3.Add borrower\n4.Add book\n5.Delete a book\n6.Display Book");
								int lOption=intsc.nextInt();
								switch(lOption)
								{
									case 1: user1.search(booksList);
											break;
									case 2: user1.loan_history(booksBorrowedList);
											break;
									case 3: user1.add_borrower(borrowerList);
											break;
									case 4: user1.add_book(booksList);
											break;
									case 5: user1.delete(booksList);
											break;
									case 6: user1.display(booksList);
											break;
								}
								System.out.println("Do you want to continue(Y/y)");
								libOption = stringsc.next();
					
							}while(libOption.equalsIgnoreCase("y"));	
							break;
				case 2: String clerkOption;
						do 
						{
							System.out.println("Enter your choice:\n1.Search Book\n2.view loan history\n3.add borrower\n4.record fine of borrower\n5.Display");
							int cOption=intsc.nextInt();
							switch(cOption)
							{
								case 1: user2.search(booksList);
										break;
								case 2: user2.loan_history(booksBorrowedList);
										break;
								case 3: user2.add_borrower(borrowerList);
										break;
								case 4: user2.record_fine();
										break;
								case 5: user2.display(booksList);
										break;
							}
							System.out.println("Do you want to continue(Y/y)");
							clerkOption = stringsc.next();
						}while(clerkOption.equalsIgnoreCase("y"));
						break;
				case 3: String borrowerOption;
						do 
						{
							System.out.println("Enter your choice:\n1.Search Book\n2.view loan history\n3.Request loan\n4.Borrow Books\n5.Display");
							int bOption = intsc.nextInt();
							switch(bOption)
							{
								case 1: user3.search(booksList);
										break;
								case 2: user3.loan_history(booksBorrowedList);
										break;
								case 3: user3.request_loan();
										break;
								case 4: user3.borrow(booksList,booksBorrowedList,borrowerList);
										break;
								case 5: user3.display(booksList);
										break;
							}
							System.out.println("Do you want to continue(Y/y)");
							borrowerOption = stringsc.next();
						}while(borrowerOption.equalsIgnoreCase("y"));
			}
			System.out.println("Do you want to switch user((Y/y))");
			userChoice = stringsc.next();			
		}while(userChoice.equalsIgnoreCase("Y"));

	}
}
