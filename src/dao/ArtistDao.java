package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Album;
import entity.Artist;
import entity.Song;

public class ArtistDao {
	
	private Connection connection;
	private AlbumDao albumDao = new AlbumDao();
	private SongDao songDao = new SongDao();
	private final String DISPLAY_ALL_ARTISTS_QUERY = "SELECT * FROM artists";
	private final String CREATE_NEW_ARTIST_QUERY = "INSERT INTO artist(artist_name, active_from) VALUES(?, ?) ";
	private final String DELETE_ARTIST_BY_NAME_QUERY = "DELET FROM artist WHERE artist_name = ?";
	
	public ArtistDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Artist> getArtist() throws SQLException {
        ResultSet rs = connection.prepareStatement(DISPLAY_ALL_ARTISTS_QUERY).executeQuery();
        List<Artist> artists = new ArrayList<Artist>();
        while (rs.next()) {
        	String artistName = rs.getString(1);
        	List<Song> songs = songDao.getSongsByArtistName(artistName);
        	List<Album> albums = albumDao.getAlbumsByArtistName(artistName)
            artists.add(new Artist(artistName, rs.getInt(2), albums, songs));
        }
        return artists;
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
