package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(String title, String category, String artist, String director, float cost) {
		super(title, category, director, cost);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category) {
		super(title, category);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

    public String getArtist() {
        return artist;
    }

    public boolean addTrack(Track track) {
    	if (tracks == null) {
            tracks = new ArrayList<>();
        }
		if (this.tracks.contains(track)) {
			System.out.println("The track " + track.getTitle() + " is already in the tracklist of " + this.getTitle());
			return false;
		} else {
			this.tracks.add(track);
			System.out.println("The track " + track.getTitle() + " has been added to the tracklist of " + this.getTitle());
			return true;
		}
	}
	
	public boolean removeTrack(Track track) {
		if (this.tracks.remove(track)) {
			System.out.println("The track " + track.getTitle() + " has been removed from the tracklist of " + this.getTitle());
			return true;
		} else {
			System.out.println("The track " + track.getTitle() + " is not in the tracklist of " + this.getTitle());
			return false;
		}
	}

    public int getLength() {
    	if (tracks == null) {
            tracks = new ArrayList<>();
        }
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("Artist: " + getArtist());
        System.out.println("CD Length: " + getLength());

        for (Track track : tracks) {
            track.play();
        }
    }
    
    @Override
    public String toString() {
        return "ID: " + getId() +", Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + ", Artist: " + artist + ", Length: " + getLength();
    }
}

