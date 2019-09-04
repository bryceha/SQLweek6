package entity;

import java.util.List;

public class Artist {

	private String artistName;
	private int formationYear;
	private List<Album> albums;
	private List<Song> songs;
	
	public Artist(String artistName, int formationYear) {
		this.setArtistName(artistName);
		this.setFormationYear(formationYear);
	}
	
	public Artist(String artistName, int formationYear, List<Album> albums, List<Song> songs) {
		this.setArtistName(artistName);
		this.setFormationYear(formationYear);
		this.setAlbums(albums);
		this.setSongs(songs);
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public int getFormationYear() {
		return formationYear;
	}

	public void setFormationYear(int formationYear) {
		this.formationYear = formationYear;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
}
