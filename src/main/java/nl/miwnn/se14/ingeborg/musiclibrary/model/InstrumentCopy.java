package nl.miwnn.se14.ingeborg.musiclibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author Ingeborg Frentz
 * Multiples of instruments
 */

@Entity
public class InstrumentCopy {
    @Id @GeneratedValue
    private Long instrumentCopyId;

    private Boolean available;

    @ManyToOne
    private Instrument instrument;

    public InstrumentCopy() {
        available = true;
    }

    public Long getInstrumentCopyId() {
        return instrumentCopyId;
    }

    public void setInstrumentCopyId(Long instrumentCopyId) {
        this.instrumentCopyId = instrumentCopyId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
