package hust.soict.dsai.aims.media;
import java.util.Comparator;

public abstract class Media {
	private int id;
	private static int nbMedia = 1;
    private String title;
    private String category;
    private float cost;
    
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbMedia;
		nbMedia += 1;
	}


	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
		this.id = nbMedia;
		nbMedia += 1;
	}    


	public Media(String title) {
		super();
		this.title = title;
		this.id = nbMedia;
		nbMedia += 1;
	}
    
    public boolean search(String title) {
		return this.title.toLowerCase().contains(title.toLowerCase());
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Media media = (Media) obj;
        return title.equals(media.title);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Category: " + category + ", Cost: " + cost;
    }

}
