import java.util.Arrays;

public class Playlist {
    static class SongPlaylist {
        private final String[] songs;
        private int songCount;

        SongPlaylist(int maxSongs) {
            songs = new String[maxSongs];
            songCount = 0;
        }

        public void addSong(String song) {
            if (songCount < songs.length) {
                songs[songCount++] = song;
            } else {
                System.out.println("Playlist is full.");
            }
        }

        public String[] getSongs() {
            return Arrays.copyOf(songs, songCount);
        }

        public int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {
        SongPlaylist p = new SongPlaylist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Playlist songs: " + Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}
