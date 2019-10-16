package comparator;

public class Song 
{
    String title;
    String artist;
    int rating;
    int bpm;
    
    public Song(String t, String a, int r, int b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }
    
    public Song(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = Integer.parseInt(r);
        bpm = Integer.parseInt(b);
    }
    
    public boolean equals(Object aSong) {
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }
    
    public int hashCode() {
        return title.hashCode();
    }
    
   

    public String getArtist()
    {
        return artist;
    }

    public int getBpm()
    {
        return bpm;
    }

    public int getRating()
    {
        return rating;
    }

    public String getTitle()
    {
        return title;
    }
    
    public String toString() {
        return title;
    }

}

