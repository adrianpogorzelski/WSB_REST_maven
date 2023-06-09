package wsb.rest.wsb_rest_maven.controllers;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wsb.rest.wsb_rest_maven.models.Song;
import wsb.rest.wsb_rest_maven.services.SongService;

import java.util.List;

@RestController
public class SongController {

    final private SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/songs")
    List<Song> findAll() {
        return songService.findAll();
    }

    @GetMapping("/songs/{id}")
    ResponseEntity<Song> find(@PathVariable Long id) {
        Song song = songService.find(id);
        if (song != null) {
            return ResponseEntity.ok(song);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/songs")
    ResponseEntity<Song> create(@RequestBody Song song) {
        Song createdSong = songService.create(song);
        if (createdSong != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdSong);
        } else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    @PutMapping("/songs/{id}")
    ResponseEntity<Song> update(@PathVariable Long id, @RequestBody Song song) {
        Song updatedSong = songService.update(id, song);
        if (updatedSong != null) {
            return ResponseEntity.ok(updatedSong);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/songs/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        songService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
