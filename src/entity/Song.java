package entity;

public class Song {

	private int songId;
	private String songName;
	private int albumId;
	private String artistName;
	
	public Song(int songId, String songName, int albumId, String artistName) {
		this.setSongId(songId);
		this.setSongName(songName);
		this.setAlbumId(albumId);
		this.setArtistName(artistName);
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
}
