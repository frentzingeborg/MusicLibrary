package nl.miwnn.se14.ingeborg.musiclibrary.resources;

import nl.miwnn.se14.ingeborg.musiclibrary.model.SheetMusic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ingeborg Frentz
 * Purpose of document
 */
public interface SheetMusicRepository extends JpaRepository<SheetMusic, Long> {

}
