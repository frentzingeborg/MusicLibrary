package nl.miwnn.se14.ingeborg.musiclibrary.resources;

import nl.miwnn.se14.ingeborg.musiclibrary.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
}
