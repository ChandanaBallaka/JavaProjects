package springcasestudy;

public class Book 
{
	int id;
	String book_name, author;
	
	Book(int id,String book_name, String author)
	{
		this.id=id;
		this.book_name=book_name;
		this.author = author;
	}
	public int getId() {
		return id;
	}

	public String getBook_name() {
		return book_name;
	}

	public String getAuthor() {
		return author;
	}

}
