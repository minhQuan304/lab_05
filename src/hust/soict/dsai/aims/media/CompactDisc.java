package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
    public CompactDisc(String title, String artist) {
		super(title);
		this.artist = artist;
		this.tracks = new ArrayList<>();
	}
    
    public CompactDisc(String title, String artist, ArrayList<Track> tracks) {
		super(title);
		this.artist = artist;
		this.tracks = tracks;
	}
    
    public CompactDisc(String title, String category, float cost, String artist, ArrayList<Track> tracks) {
		super(title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
    
    public CompactDisc(String title, String category, float cost, String artist) {
    	super(title, category, cost);
    	this.artist = artist;
    }

	public CompactDisc(String title, String category, String director, float cost, String artist, ArrayList<Track> tracks) {
		super(title, category, director, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	public CompactDisc(int id, String title, String category, String director, float cost, String artist) {
		super(id, title, category, director, cost);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
		super( title, category, director, cost);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("Track already exists");
		}
		else {
			tracks.add(track);
			System.out.println("Added");
			}
	}
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Removed");
		}
		else {
			System.out.println("Track does not exist");
			}
	}
	
	public int getLength() {
		int sumLength = 0;
		for (Track track : tracks) {
			sumLength += track.getLength();
		}
		return sumLength;
	}
	
	public void play() throws PlayerException{
		if (this.getLength() > 0) {
			System.out.println("Compactdisc: " + getTitle());
			System.out.println("Artist: " + getArtist());
			System.out.println("Length: " + getLength());
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while (iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					nextTrack.play();
				}
				catch(PlayerException e ) {
					throw e;
					}
			}
		}
		else {
			throw new PlayerException("Error: DVD length is non-positive!");
		}
		
		
		for (Track track : tracks) {
			track.play();
		}
	}
	
}
