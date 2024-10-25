package nl.miwnn.se14.ingeborg.musiclibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

/**
 * @author Ingeborg Frentz
 * Instrumentation of a piece of music
 */

@Entity
public class Instrument {

    @Id @GeneratedValue
    private Long instrumentId;
    private String instrumentName;

    @OneToMany(mappedBy = "instrument")
    private Set<InstrumentCopy> instrumentcopies;

    public Long getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Long instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public Set<InstrumentCopy> getInstrumentcopies() {
        return instrumentcopies;
    }

    public void setInstrumentcopies(Set<InstrumentCopy> instrumentcopies) {
        this.instrumentcopies = instrumentcopies;
    }
}
