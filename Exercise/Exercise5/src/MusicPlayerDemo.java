import java.util.*;

// Singleton Pattern
class MusicPlayer {
    private static final MusicPlayer instance = new MusicPlayer();

    private MusicPlayer() {}

    public static MusicPlayer getInstance() {
        return instance;
    }

    public void playMusic(Playlist playlist){
        for (Music music: playlist.getMusics()) {
            music.play();
        }
    }
}


// Factory Pattern
abstract class Music {
    String name;

    public String toString() {
        return name;
    }

    abstract void play();
}

class MP3Music extends Music {
    public MP3Music(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Playing MP3 music: " + name);
    }
}

class WAVMusic extends Music {
    public WAVMusic(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Playing WAV music: " + name);
    }
}

class WMAMusic extends Music {
    public WMAMusic(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Playing WMA music: " + name);
    }
}

class MusicFactory {
    public Music createMusic(String musicType, String name) {
        if (musicType == null) {
            return null;
        }
        if (musicType.equalsIgnoreCase("MP3Music")) {
            return new MP3Music(name);
        } else if (musicType.equalsIgnoreCase("WAVMusic")) {
            return new WAVMusic(name);
        } else if (musicType.equalsIgnoreCase("WMAMusic")) {
            return new WMAMusic(name);
        }
        return null;
    }
}

// Observer Pattern
class Playlist {
    private List<Music> musics= new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public List<Music> getMusics() {
        return musics;
    }

    public void addMusic(Music music) {
        musics.add(music);
        notifyObservers(music);
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(Music music) {
        for (Observer observer: observers) {
            observer.update(music);
        }
    }
}

abstract class Observer {
    protected String name;
    protected List<Playlist> playlists = new ArrayList<>();

    public abstract void update(Music music);
}

class User extends Observer {
    public User (String userName) {
        this.name = userName;
    }

    public void subscribePlaylist(Playlist playlist) {
        playlists.add(playlist);
        playlist.registerObserver(this);
    }

    @Override
    public void update(Music music){
        System.out.println(name + " received notification: " + music + " has been added to the playlist.");
    }
}


public class MusicPlayerDemo {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = MusicPlayer.getInstance();
        MusicFactory musicFactory = new MusicFactory();

        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");

        Music music1 = musicFactory.createMusic("MP3Music", "music1");
        Music music2 = musicFactory.createMusic("WAVMusic", "music2");
        Music music3 = musicFactory.createMusic("WMAMusic", "music3");

        Playlist playlist = new Playlist();

        user1.subscribePlaylist(playlist);
        user2.subscribePlaylist(playlist);
        user3.subscribePlaylist(playlist);

        playlist.addMusic(music1);
        playlist.addMusic(music2);
        playlist.addMusic(music3);

        musicPlayer.playMusic(playlist);
    }
}



