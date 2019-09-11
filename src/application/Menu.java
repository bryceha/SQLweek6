package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.AlbumDao;
import dao.ArtistDao;
import dao.SongDao;
import entity.Album;
import entity.Artist;
import entity.Song;

public class Menu {
	
	private ArtistDao artistD = new ArtistDao(); 
	private AlbumDao albumD = new AlbumDao();
	private SongDao songD = new SongDao();
	private Scanner scanner = new Scanner(System.in);

	//	private List<Artist> artistNames = artistD.getArtists();
//	private List<Album> albumIds = albumD.getAlbumId();
//	private List<Song> songIds = songD.getSongId();
//	private List<String> albumOptions = Arrays.asList(
//			"album name",
//			"release date",
//			"genre",
//			"artist name");
//	private List<String> songOptions = Arrays.asList(
//			"song name",
//			"album ID",
//			"artist name");

	private List<String> options = Arrays.asList(
			"Display All Artists",
			"Enter New Artist",
			"Delete an Artist",
			"Update an Artist",
			"Display Artist's Albums",
			"Enter New Album",
			"Delete an Album",
			"Update an Album",
			"Display Artist's Songs",
			"Display Album's Songs",
			"Enter New Song",
			"Delete a Song",
			"Update a Song"
			);

	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
		
		try {	
			if (selection.equals("1")) {
				displayAllArtists();
			} else if (selection.equals("2")) {
				enterNewArtist();
			} else if (selection.equals("3")) {
				deleteAnArtist();
			} else if (selection.equals("4")) {
				//updateAnArtist();
			} else if (selection.equals("5")) {
				displayArtistsAlbums();
			} else if (selection.equals("6")) {
				enterNewAlbum();
			} else if (selection.equals("7")) {
				deleteAnAlbum();
			} else if (selection.equals("8")) {
				//updateAnAlbum();
			} else if (selection.equals("9")) {
				displayArtistsSongs();
			} else if (selection.equals("10")) {
				displayAlbumsSongs();
			} else if (selection.equals("11")) {
				enterNewSong();
			} else if (selection.equals("12")) {
				deleteASong();
			} else if (selection.equals("13")) {
				//updateASong();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
			System.out.println("Press enter to continue...");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n~~~~~~~~~~~~~~~~~~~");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
//	private void printMenu2() {
//		System.out.println("Choose what to update:\n~~~~~~~~~~~~~");
//		for (int i = 0; i < albumOptions.size(); i++) {
//			System.out.println(i + 1 + ") " + albumOptions.get(i));
//		}
//	}
//	
//	private void printMenu3() {
//		System.out.println("Choose what to update:\n~~~~~~~~~~~~~");
//		for (int i = 0; i < songOptions.size(); i++) {
//				System.out.println(i + 1 + ") " + songOptions.get(i));
//		}
//	}
//	
	private void displayAllArtists() throws SQLException {
		List<Artist> artists = artistD.getArtists();
		for(Artist artist : artists) {
			System.out.println(artist.getArtistName() + " : " + artist.getActiveFrom());
		}
	}
	
	private void enterNewArtist() throws SQLException {
		System.out.print("Enter new artist's name: ");
		String artistName = scanner.nextLine();
//		while (artistNames.contains(artistName)) {
//			System.out.println("Warning! Artist by this name exists. Please make a unique entry.");
//			artistName = scanner.nextLine();
//		} 
		System.out.print("Enter date artist began preforming: ");
		int activeFrom = Integer.parseInt(scanner.nextLine());
		artistD.createNewArtist(artistName, activeFrom);
		System.out.println("New artist created.");
	}
	
	private void deleteAnArtist() throws SQLException {
		System.out.print("Enter the name of the artist to delete: ");
		String artistName = scanner.nextLine();
//		while (!artistNames.contains(artistName)) {
//			System.out.println("Does not exist! Please type a valid artist name.");
//			artistName = scanner.nextLine();
//		}
		artistD.deleteArtistByName(artistName);
		System.out.println("Artist deleted.");
	}
	
//	private void updateAnArtist() throws SQLException {
//		System.out.println("Enter the name of the artist to update:");
//		String artistName = scanner.nextLine();
//		while (!artistNames.contains(artistName)) {
//			System.out.println("Does not exist! Please type a valid artist name.");
//			artistName = scanner.nextLine();
//		}
//		System.out.println("Type update:");
//		String update = scanner.nextLine();
//		artistD.updateArtist(artistName, update);
//		System.out.println("Artist updated.");
//	}
	
	private void displayArtistsAlbums() throws SQLException {
		System.out.print("Enter artist's name: ");
		String name = scanner.nextLine();
		List<Album> albums = albumD.getAlbumsByArtistName(name);
		for(Album album : albums) {
			System.out.println(album.getAlbumId() + " : " + album.getAlbumName() + " : " + album.getReleaseDate()
			+ " : " + album.getGenre());
		}
		
	}
	
	private void enterNewAlbum() throws SQLException {
		System.out.print("Enter album name: ");
		String albumName = scanner.nextLine();
		System.out.print("Enter release date: ");
		String releaseDate = scanner.nextLine();
		System.out.print("Enter genre: ");
		String genre = scanner.nextLine();
		System.out.print("Enter name of artist: ");
		String artistName = scanner.nextLine();
		albumD.createNewAlbum(albumName, releaseDate, genre, artistName);
		System.out.println("New album created.");
	}
	
	private void deleteAnAlbum() throws SQLException {
		System.out.print("Enter the album ID to delete: ");
		int albumId = Integer.parseInt(scanner.nextLine());
//		while (!albumIds.contains(albumId)) {
//			System.out.println("Does not exist! Please type a valid album ID.");
//			albumId = Integer.parseInt(scanner.nextLine());
//		}
		albumD.deleteAlbumById(albumId);
		System.out.println("Album deleted.");
	}
	
//	private void updateAnAlbum() throws SQLException {
//		System.out.println("Enter the album ID to update:");
//		int albumId = Integer.parseInt(scanner.nextLine());
//		while (!albumIds.contains(albumId)) {
//			System.out.println("Does not exist! Please type a valid album ID.");
//			albumId = Integer.parseInt(scanner.nextLine());
//		}
//		printMenu2();
//		String selection = scanner.nextLine();
//		while (!albumOptions.contains(selection)) {
//			System.out.println("This is not one of the given options. Please type an option.");
//			selection = scanner.nextLine();
//		}
//		System.out.println("Type update:");
//		String update = scanner.nextLine();
//		albumD.updateAlbum(albumId, selection, update);
//		System.out.println("Album updated.");
//	}
	
	private void displayArtistsSongs() throws SQLException {
		System.out.print("Enter artist's name: ");
		String name = scanner.nextLine();
		List<Song> songs = songD.getSongsByArtistName(name);
		for(Song song : songs) {
			System.out.println(song.getSongName());
		}
	}
	
	private void displayAlbumsSongs() throws SQLException {
		System.out.print("Enter album id: ");
		int id = Integer.parseInt(scanner.nextLine());
		List<Song> songs = songD.getSongsByAlbumId(id);
		for(Song song : songs) {
			System.out.println(song.getSongId() + " : " + song.getSongName() + " : " + song.getAlbumId() + " : "
			+ song.getArtistName());
		}
	}
	
	private void enterNewSong() throws SQLException {
//		String songId = "";
//		if (songIds.isEmpty()) {
//			System.out.println("Enter new song Id:");
//			songId = scanner.nextLine();
//		} else {
//			continue;
//		}
		System.out.print("Enter new song name: ");
		String songName = scanner.nextLine();
		System.out.print("Enter album Id: ");
		int albumId = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter artist's name: ");
		String artistName = scanner.nextLine();
		songD.enterNewSong(songName, albumId, artistName);
		System.out.println("New song created.");
	}
	
	private void deleteASong() throws SQLException {
		System.out.print("Enter the song ID to delete: ");
		int songId = Integer.parseInt(scanner.nextLine());
//		while (!songIds.contains(songId)) {
//			System.out.println("Does not exist! Please type a valid song ID.");
//			songId = Integer.parseInt(scanner.nextLine());
//		}
		songD.deleteSongById(songId);
		System.out.println("Song deleted.");
	}
	
//	private void updateASong() throws SQLException {
//		System.out.println("Enter song ID to update:");
//		int songId = Integer.parseInt(scanner.nextLine());
//		while (!songIds.contains(songId)) {
//			System.out.println("Does not exist! Please type a valid song ID.");
//			songId = Integer.parseInt(scanner.nextLine());
//		}
//		printMenu3();
//		String selection = scanner.nextLine();
//		while (!songOptions.contains(selection)) {
//			System.out.println("This is not one of the given options. Please type an option.");
//			selection = scanner.nextLine();
//		}
//		System.out.println("Type update:");
//		String update = scanner.nextLine();
//		artistD.updateSong(songId, selection, update);
//		System.out.println("Song updated.");
//	}
}
