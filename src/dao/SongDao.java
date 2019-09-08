package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SongDao {
	private Connection connection;
	//does not let me make (import) a connection ??
	
	private final String GET_SONGS_QUERY = "SELECT * FROM songs";
	private final String ENTER_NEW_SONG_QUERY = "INSERT INTO song VALUES(?)";
	private final String UPDATE_SONG_BY_ID_QUERY = "UPDATE songs WHERE id = ?";
	private final String DELETE_SONG_BY_ID_QUERY = "DELETE FROM songs WHERE id = ?";
	
	public SongDao() {
		connection = DBconnection.getConnection();
	}

	public List<Song> getSongs() {
		ResultSet rs = connection.prepareStatement(GET_SONGS_QUERY).executeQuery();
		List<Song> songs = new ArrayList<Song>();
	//does not let me import rs - OR list - OR song entity package - OR arraylist??
		//need to also throw exception
		
		while (rs.next()) {
			songs.add(populateSong(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
		}
	
	return songs;
}
	public void enterNewSong(String songName) {
		PreparedStatement ps = connection.prepareStatement(ENTER_NEW_SONG_QUERY); 
		ps.setString(1, songName);
		ps.executeUpdate();
	
	}
	
	public void updateSongById(int songId) {
		PreparedStatement ps = connection.prepareStatement(UPDATE_SONG_BY_ID_QUERY); 
		ps.setInt(1, songId);
		ps.executeUpdate();
	
	}
	
	public void deleteSongtById(int id) {
		PreparedStatement ps = connection.prepareStatement(DELETE_SONG_BY_ID_QUERY);
		ps.setInt(1, songId);
		ps.executeUpdate();
	}
	
	private Song populateSong(int songId, String songName, int albumId, String artistName) {
		return new Song(songId, songName, albumId, artistName);

	}
	
	
	
