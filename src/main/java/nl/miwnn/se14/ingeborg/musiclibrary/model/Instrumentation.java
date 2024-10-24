package nl.miwnn.se14.ingeborg.musiclibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Ingeborg Frentz
 * Instrumentation of a piece of music
 */

@Entity
public class Instrumentation {

    @Id @GeneratedValue
    private Long instrumentId;
    private String intrumentName;

    public Long getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Long instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getIntrumentName() {
        return intrumentName;
    }

    public void setIntrumentName(String intrumentName) {
        this.intrumentName = intrumentName;
    }
}
