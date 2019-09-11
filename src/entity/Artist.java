package entity;

import java.util.List;

public class Artist {

	private String artistName;
	private int activeFrom;
	private List<Album> albums;
	private List<Song> songs;
	

	public Artist(String artistName, int activeFrom, List<Album> albums, List<Song> songs) {
		this.setArtistName(artistName);
		this.setActiveFrom(activeFrom);
		this.setAlbums(albums);
		this.setSongs(songs);
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public int getActiveFrom() {
		return activeFrom;
	}

	public void setActiveFrom(int activeFrom) {
		this.activeFrom = activeFrom;
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
