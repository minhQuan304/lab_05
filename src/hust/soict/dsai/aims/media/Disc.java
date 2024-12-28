package hust.soict.dsai.aims.media;

public class Disc extends Media {
	
	private String director;
	private int length;
	
	public Disc(String title) {
		super();
		setTitle(title);
	}
	public Disc(String title, String category, float cost) {
		super();
		setTitle(title);
		setCategory(category);
		setCost(cost);
	}
	public Disc(String title, String category, String director, float cost) {
		super();
		setTitle(title);
		setCategory(category);
		setCost(cost);
		this.director = director;
	}
	public Disc(int id, String title, String category, String director, float cost) {
		super();
		setId(id);
		setTitle(title);
		setCategory(category);
		this.director = director;
		setCost(cost);
	}
	public Disc(String title, String category, String director, int length, float cost) {
		super();
		setTitle(title);
		setCategory(category);
		setCost(cost);
		this.director = director;
		this.length = length;
	}
	public Disc(int id, String title, String category, String director, int length, float cost) {
		super();
		setId(id);
		setTitle(title);
		setCategory(category);
		setCost(cost);
		this.director = director;
		this.length = length;
	}
	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

}
