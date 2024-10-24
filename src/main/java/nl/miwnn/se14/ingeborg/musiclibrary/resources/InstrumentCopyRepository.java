package nl.miwnn.se14.ingeborg.musiclibrary.resources;

import nl.miwnn.se14.ingeborg.musiclibrary.model.InstrumentCopy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentCopyRepository extends JpaRepository<InstrumentCopy, Long> {
}
