package wsb.rest.wsb_rest_maven.repositories;
import org.springframework.stereotype.Repository;
import wsb.rest.wsb_rest_maven.models.Song;
import java.util.List;
import java.util.LinkedList

@Repository
public class SongRepository {

    static List<Song> songs = new LinkedList<>() {{
        add(new Song(1L, "Zbigniew Martynski", "Zycie to moment", 1990L));
        add(new Song(2L, "Ron Barley", "High as a mountain", 1975L));
        add(new Song(3L, "The Black Satans", "Satanic darkness", 1991L));
    }};

    public List<Song> findAll() {
        return songs
    }
}
