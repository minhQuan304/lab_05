package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	public Book(int id, String title, String category, float cost) {
		// TODO Auto-generated constructor stub
//		super(id, title, category, cost);
//		super(id);
		super();
		setId(id);
		setTitle(title);
		setCategory(category);
		setCost(cost);
	}
	
	public Book(String title, String category, float cost) {
		super();
		setTitle(title);
		setCategory(category);
		setCost(cost);
	}
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Author already exists");
	}
		else {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		authors.remove(authorName);
	}

}
