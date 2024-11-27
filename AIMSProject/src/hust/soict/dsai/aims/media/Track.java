package hust.soict.dsai.aims.media;

public class Track implements Playable{

	private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    
    @Override
    public void play() {
    	System.out.println("Playing Track: " + getTitle());
        System.out.println("Track Length: " + getLength());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Track track = (Track) obj;
        return length == track.length && title.equals(track.title);
    }

}
