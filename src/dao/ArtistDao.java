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
	private final String DISPLAY_ALL_ARTISTS_QUERY = "SELECT * FROM artists";
	private final String CREATE_NEW_ARTIST_QUERY = "INSERT INTO artist(artist_name, active_from) VALUES(?, ?) ";
	private final String DELETE_ARTIST_BY_NAME_QUERY = "DELET FROM artist WHERE artist_name = ?";
	
	public ArtistDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Artist> getArtist() {
        ResultSet rs = connection.prepareStatement(DISPLAY_ALL_ARTISTS_QUERY).executeQuery();
        List<Artist> artists = new ArrayList<Artist>();
        while (rs.next()) {
            artists.add((rs.getString(1)));
        }
        return getArtist();
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
