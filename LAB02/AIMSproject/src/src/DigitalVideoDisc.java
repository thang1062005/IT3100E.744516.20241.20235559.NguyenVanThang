package src;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String title, String cat, float co) {
		super();
		this.title = title;
		this.category= cat;
		this.cost = co;
	}
	public DigitalVideoDisc(String title, String cat, String d, float co) {
		super();
		this.title = title;
		this.category= cat;
		this.director = d;
		this.cost = co;
	}
	public DigitalVideoDisc(String title, String cat, String d, int length, float co) {
		super();
		this.title = title;
		this.category= cat;
		this.director = d;
		this.length = length;
		this.cost = co;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
}

