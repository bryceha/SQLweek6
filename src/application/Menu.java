package application;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display All Artists",
			"Enter New Artist",
			"Delete an Artist",
			"Display Artist's Albums",
			"Enter New Album",
			"Delete an Album",
			"Display Artist's Songs",
			"Display Album's Songs",
			"Enter New Song",
			"Delete a Song"
			);

	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			if (selection.equals("1")) {
				//displayAllArtists();
			} else if (selection.equals("2")) {
				//enterNewArtist();
			} else if (selection.equals("3")) {
				//deleteAnArtist();
			} else if (selection.equals("4")) {
				//displayArtistsAlbum();
			} else if (selection.equals("5")) {
				//enterNewAlbum();
			} else if (selection.equals("6")) {
				//deleteAnAlbum();
			} else if (selection.equals("7")) {
				//displayArtistsSongs();
			} else if (selection.equals("8")) {
				//displayAlbumsSongs();
			} else if (selection.equals("9")) {
				//enterNewSong();
			} else if (selection.equals("10")) {
				//deleteASong();
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
}
