package comparator;

import java.util.*;
import java.io.*;

public class JukeBox {
	ArrayList<Song> songList = new ArrayList<Song>();

	public ArrayList<Song> getSongList() {
		return songList;
	}

	public void setSongList(ArrayList<Song> songList) {
		this.songList = songList;
	}

	public static void main(String[] args) {
		int[] intArray = { 10, 49, -1, 0, 200 };
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < intArray.length; ++i) {
			intList.add(intArray[i]);
		}
		Collections.sort(intList);
		for (Object a : intList) {
			System.out.println(a);
		}
		JukeBox jb = new JukeBox();
		jb.getSongs();
		System.out.println("Song list before sorting");
		for (Song s : jb.getSongList()) {
			System.out.println(s);
		}
		
		Comparator<Song> titleComparator = new Comparator<Song>() {
			
			@Override
			public int compare(Song o1, Song o2) {
				return (o1.getTitle().compareTo(o2.getTitle())) * -1;
			}
		};
		
		Collections.sort(jb.getSongList());
		
		System.out.println("Song list after sorting");
		for (Song s : jb.getSongList()) {
			System.out.println(s);
		}
	}

	void getSongs() {
		try {
			File file = new File("SongListMore.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				addSong(line);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	void addSong(String lineToParse) {
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nextSong);
	}
}
