package wsb.rest.wsb_rest_maven.repositories;
import org.springframework.stereotype.Repository;
import wsb.rest.wsb_rest_maven.models.Song;
import java.util.List;
import java.util.LinkedList;

@Repository
public class SongRepository {

    static Long currentId = 4L;

    static List<Song> songs = new LinkedList<>() {{
        add(new Song(1L, "Zenobiusz Martynski", "Zycie to moment", 1990L));
        add(new Song(2L, "Ron Barley", "High as a mountain", 1975L));
        add(new Song(3L, "The Black Satans", "Satanic darkness", 1991L));
    }};

    public static Song find(Long id) {
        return songs.stream()
                .filter(song -> song.getId()
                .equals(id)).findFirst()
                .orElse(null);
    }

    public List<Song> findAll() {
        return songs;
    }

    public Song create(Song song) {
        Song createdSong = new Song(
                currentId++,
                song.getAuthor(),
                song.getTitle(),
                song.getYear()
        );

        songs.add(createdSong);
        return createdSong;
    }
}
