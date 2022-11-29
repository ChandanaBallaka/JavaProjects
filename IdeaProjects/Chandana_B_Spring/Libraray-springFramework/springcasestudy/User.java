package springcasestudy;

import java.util.List;

interface User 
{
	public void search(List<Book> bookList);
	public void loan_history(List<BooksBorrowed> booksBorrowedList);
}
