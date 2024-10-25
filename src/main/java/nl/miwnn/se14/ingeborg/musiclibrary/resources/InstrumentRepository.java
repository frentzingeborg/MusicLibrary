package nl.miwnn.se14.ingeborg.musiclibrary.resources;

import nl.miwnn.se14.ingeborg.musiclibrary.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    Optional<Instrument> findByInstrumentName(String instrumentName);
    Optional<Instrument> deleteByInstrumentName(String instrumentName);
}
