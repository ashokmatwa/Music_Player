import java.util.*;

public class Album {

    private String name;
    private String artist;
    private List<Song> songs; //data type Song--> need every detail of song
//    private HashSet<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;

        this.songs = new ArrayList<>();
//        this.songs = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }


//    public HashSet<Song> getSongs() {
//        return songs;
//    }
//
//    public void setSongs(HashSet<Song> songs) {
//        this.songs = songs;
//    }

    public boolean findSong(String title){
        for(Song s : songs){                    //iterating over songs list
            if(s.getTitle().equals(title))
                return true;
        }
        return false;
    }

//    When you don't override them, the equals method tests equality of the objects' references
//    rather that equality of their field values.

//    public boolean findSong(Song song){
//        return songs.contains(song);
//    }

    void addSongsToAlbum(String name, double duration){
        Song s = new Song(name, duration);
//        songs.add(s);

        if(findSong(s.getTitle()) == true){
            System.out.println("already present");
        }
//        if(findSong(s)){
//            System.out.println("already present");
//        }
        else{
            songs.add(s);
            System.out.println("new song has been added");
        }
    }



    //polymorphism
    public void addToPlaylistFromAlbum(String title, LinkedList<Song> playList){
        if(findSong(title) == true){
            for(Song song : songs){
                if(song.getTitle().equals(title)){
                    playList.add(song);
                    System.out.println(song + " : song has been added to playlist");
                    break;
                }
            }
        }
        else{
            System.out.println("song is not present");
        }
    }

    public void addToPlaylistFromAlbum(int trackNo, LinkedList<Song> playList){
        int index = trackNo-1;
        if(index>=0 && index<songs.size()){
            playList.add(songs.get(index));
            System.out.println(songs.get(index) + " : song has been added to playlist");
        }
        else{
            System.out.println("Invalid track no");
        }
    }
}
