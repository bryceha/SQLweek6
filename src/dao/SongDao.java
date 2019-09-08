package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Song;

public class SongDao {
	
	private Connection connection;
	
	//need to change these to be by specific 
	private final String GET_SONGS_BY_ARTIST_NAME_QUERY = "SELECT * FROM songs WHERE artist_name = ?";
	private final String GET_SONGS_BY_ALBUM_ID_QUERY = "SELECT * FROM songs WHERE album_id = ?";
	private final String ENTER_NEW_SONG_QUERY = "INSERT INTO songs(song_name, album_id, artist_name) VALUES(?, ?, ?)";
	private final String UPDATE_SONG_BY_ID_QUERY = "UPDATE songs WHERE song_id = ?";
	private final String DELETE_SONG_BY_ID_QUERY = "DELETE FROM songs WHERE song_id = ?";
	
	public SongDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Song> getSongsByArtistName(String artistName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_SONGS_BY_ARTIST_NAME_QUERY);
		ps.setString(1, artistName);
		ResultSet rs = ps.executeQuery();
		List<Song> songs = new ArrayList<Song>();
		
		while (rs.next()) {
			songs.add(populateSong(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
		}
		
		return songs;
		
	}	
	
	public List<Song> getSongsByAlbumId(int albumId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_SONGS_BY_ALBUM_ID_QUERY);
		ps.setInt(1, albumId);
		ResultSet rs = ps.executeQuery();
		List<Song> songs = new ArrayList<Song>();
		
		while (rs.next()) {
			songs.add(populateSong(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
		}
		
		return songs;
		
	}
		
		public void enterNewSong(String songName, int albumId, String artistName) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(ENTER_NEW_SONG_QUERY);
			ps.setString(1, songName);
			ps.setInt(2, albumId);
			ps.setString(3, artistName);
			ps.executeUpdate();
		}
	
		public void updateSongById(int songId) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(UPDATE_SONG_BY_ID_QUERY);	
			ps.setInt(1, songId);
			ps.executeUpdate();
		}
		
		public void deleteSongById(int id) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(DELETE_SONG_BY_ID_QUERY);
			ps.setInt(1, id);
			ps.executeUpdate();
		}
		
		private Song populateSong(int songId, String songName, int albumId, String artistName) {
			return new Song(songId, songName, albumId, artistName); 
		}
		
	}