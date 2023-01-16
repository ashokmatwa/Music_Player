import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album1 = new Album("Moosa", "Sidhu Moosewala");
        album1.addSongsToAlbum("295",4.05);
        album1.addSongsToAlbum("Last Ride",5.5);
        album1.addSongsToAlbum("So high",3.05);

        album1.addSongsToAlbum("So high",3.05); //check duplicate

        Album album2 = new Album("Arijist's Songs", "Arigit");
        album2.addSongsToAlbum("Kesariya", 5.09);
        album2.addSongsToAlbum("Jeena", 4.08);
        album2.addSongsToAlbum("Gerua", 6);

        albums.add(album1);
        albums.add(album2);

        System.out.println(album1.findSong("295"));

        LinkedList<Song> myPlayList = new LinkedList<>(); //for access of previous and forward songs
        album1.addToPlaylistFromAlbum("295", myPlayList);
        album2.addToPlaylistFromAlbum(2, myPlayList);


    }
}