import java.util.*;

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
        album1.addToPlaylistFromAlbum("Last Ride", myPlayList);
        album1.addToPlaylistFromAlbum("So high",myPlayList);

        album2.addToPlaylistFromAlbum("Kesariya", myPlayList);
        album2.addToPlaylistFromAlbum(2, myPlayList);
        album2.addToPlaylistFromAlbum("Gerua", myPlayList);



//        Song sample = new Song("abc", 7);
//        System.out.println(sample);

        play(myPlayList);
    }

    public static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);

        ListIterator<Song> itr = playList.listIterator();

        boolean isForward = false; // for issue resolve of different direction

        if(playList.size() > 0){
            System.out.println();
            System.out.println("currently playing");
            System.out.println(itr.next());
            isForward = true;
        }
        else{
            System.out.println("playlist is empty");
            return;
        }

        System.out.println("enter your choice : ");
        printMenu();

        boolean quit = false;
        while(!quit){
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    if(isForward == false){
                        itr.next();
                        isForward = true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else{
                        System.out.println("you have reached the end of the playlist");
                        isForward = false;
                    }
                    break;
                case 2:
                    if(isForward == true){
                        itr.previous();;
                        isForward = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("you are at the start of the playlist");
                        isForward = true;
                    }
                    break;
                case 3:
                    if(isForward == true){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isForward = false;
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isForward = true;
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    itr.remove();
                    break;
                case 6:
                    printSongs(playList);
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    public static void printSongs(LinkedList<Song> playList){
        for(Song song : playList)
            System.out.println(song);
        return;
    }
    public static void printMenu(){
//        System.out.println("Select your choice: ");
        System.out.println("1- play next song");
        System.out.println("2- play previous song");
        System.out.println("3- repeat current");
        System.out.println("4- show menu again");
        System.out.println("5- delete the current");
        System.out.println("6- print song list");
        System.out.println("7- EXIT");
    }
}