package nl.miwnn.se14.ingeborg.musiclibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Ingeborg Frentz
 * Composer of music
 */

@Entity
public class Composer {
    @Id @GeneratedValue
    private Long composerId;
    private String composerName;

    public Long getComposerId() {
        return composerId;
    }

    public void setComposerId(Long composerId) {
        this.composerId = composerId;
    }

    public String getComposerName() {
        return composerName;
    }

    public void setComposerName(String composerName) {
        this.composerName = composerName;
    }
}
