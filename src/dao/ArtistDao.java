package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Artist;

public class ArtistDao {
	
	private Connection connection;
	private AlbumDao albumDao = new AlbumDao();
	private SongDao songDao = new SongDao();
	private final String DISPLAY_ALL_ARTISTS_QUERY = "SELECT * FROM artists";
	private final String CREATE_NEW_ARTIST_QUERY = "INSERT INTO artists(artist_name, active_from) VALUES(?, ?)";
	private final String DELETE_ARTIST_BY_NAME_QUERY = "DELETE FROM artists WHERE artist_name = ?";
	
	public ArtistDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Artist> getArtists() throws SQLException {
        ResultSet rs = connection.prepareStatement(DISPLAY_ALL_ARTISTS_QUERY).executeQuery();
        List<Artist> artists = new ArrayList<Artist>();
        
        while (rs.next()) {
            artists.add(populateArtist(rs.getString(1), rs.getInt(2)));
        }
        
        return artists;
    }
	
	private Artist populateArtist(String name, int year) throws SQLException {
		return new Artist(name, year, albumDao.getAlbumsByArtistName(name), songDao.getSongsByArtistName(name));
	}
	
	public void createNewArtist(String artistName, int formationYear) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_ARTIST_QUERY);
		ps.setString(1, artistName);
		ps.setInt(2, formationYear);
		ps.executeUpdate();
		
	}
	
	public void deleteArtistByName(String artistName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_ARTIST_BY_NAME_QUERY);
		ps.setString(1, artistName);
		ps.executeUpdate();
		
	}

}