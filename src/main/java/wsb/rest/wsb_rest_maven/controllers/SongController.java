package wsb.rest.wsb_rest_maven.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wsb.rest.wsb_rest_maven.models.Song;
import wsb.rest.wsb_rest_maven.repositories.SongRepository;

import java.util.List;

@RestController
public class SongController {

    final private SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/songs")
    List<Song> findAll() {
        return songRepository.findAll();
    }
}
