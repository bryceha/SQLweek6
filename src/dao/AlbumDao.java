package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Album;
import entity.Song;

public class AlbumDao {
	
	private Connection connection;
	private ArtistDao artistDao = new ArtistDao();
	private SongDao songDao = new SongDao();
	private final String GET_ALBUMS_FROM_ARTIST_QUERY = "SELECT * FROM album WHERE artist_name = ?";
	private final String CREATE_NEW_ALBUM_QUERY = "INSERT INTO album(album_id, album_name, release_date, genre, artist_name) VALUES(?, ?, ?, ?, ?)";
	private final String DELETE_ALBUM_BY_ALBUM_ID_QUERY = "DELETE FROM album WHERE album_id = ?";
	public AlbumDao() {
		connection.DBConnection.getConnection();
	}
	public List<Album> getAlbumByArtistName(String artistName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_ALBUMS_FROM_ARTIST_QUERY);
		ps.setString(1, artistName);
		ResultSet rs = ps.executeQuery();
		List<Album> albums = new ArrayList<Album>();
		
		while (rs.next()) {
		albums.add(populateAlbum(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), List<Song> songs));	
		}
		
		return albums;
	}
	
	public void createNewAlbum(int albumId, String albumName, String releaseDate, String genre, String artistName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_ALBUM_QUERY);
		ps.setInt(1, albumId);
		ps.setString(2, albumName);
		ps.setString(3, releaseDate);
		ps.setString(4,  genre);
		ps.setString(5, artistName);
		ps.executeUpdate();
	}
	
	public void deleteAlbumById(int albumId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_ALBUM_BY_ALBUM_ID_QUERY);
		ps.setInt(1, albumId);
		ps.executeUpdate();
	}
	
	private Album populateAlbum(int albumId, String albumName, String releaseDate, String genre, String artistName) {
		return new Album(albumId,albumName, releaseDate, genre, artistName, songDao.getSongByArtistName(artistName));
	}

}
