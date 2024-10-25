package nl.miwnn.se14.ingeborg.musiclibrary.resources;

import nl.miwnn.se14.ingeborg.musiclibrary.model.SheetMusic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SheetMusicRepository extends JpaRepository<SheetMusic, Long> {
    Optional<SheetMusic> findByTitle(String title);
}
