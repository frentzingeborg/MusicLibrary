package nl.miwnn.se14.ingeborg.musiclibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

/**
 * @author Ingeborg Frentz
 * A piece of sheetmusic in our library
 */
@Entity
public class SheetMusic {
    @Id @GeneratedValue
    private Long sheetMusicId;
    private String title;
    private String composer;

    @OneToMany(mappedBy = "sheetMusic")
    private List<Copy> copies;

    public int getNumberOfPerformances() {
        int count = 0;

        for (Copy copy : copies) {
            if (copy.getAvailable()) {
                count++;
            }
        }
        return count;
    }

    public Long getSheetMusicId() {
        return sheetMusicId;
    }

    public void setSheetMusicId(Long sheetMusicId) {
        this.sheetMusicId = sheetMusicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }
}
