package entity;

import java.util.List;

public class Album {

	private int albumId;
	private String albumName;
	// idk if this date should be String or what
	private String releaseDate;
	private String genre;
	private String artistName;
	private List<Song> songs;
	
	public Album(int albumId, String albumName, String releaseDate, String genre, String artistName, List<Song> songs) {
		this.setAlbumId(albumId);
		this.setAlbumName(albumName);
		this.setReleaseDate(releaseDate);
		this.setGenre(genre);
		this.setArtistName(artistName);
		this.setSongs(songs);
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
}
