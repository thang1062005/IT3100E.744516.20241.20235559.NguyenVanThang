package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private int contentLength;
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title, String category, int contentLength, float cost) {
		super(title, category, cost);
		this.contentLength = contentLength;
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String category) {
		super(title, category);
		// TODO Auto-generated constructor stub
	}

	public Book(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println("Author: " + authorName + "be added to the book");
		}else {
			System.out.println("Author: " + authorName + "is already associated to the book");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author " + authorName + " removed from the book.");
        } else {
            System.out.println("Author " + authorName + " is not associated with the book.");
        }
	}
	
	@Override
    public String toString() {
		return super.toString() + ", Author: " + getAuthors();
    }
	
}
