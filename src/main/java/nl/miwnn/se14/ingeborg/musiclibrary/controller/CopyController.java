package nl.miwnn.se14.ingeborg.musiclibrary.controller;

import jakarta.persistence.Entity;
import nl.miwnn.se14.ingeborg.musiclibrary.model.Copy;
import nl.miwnn.se14.ingeborg.musiclibrary.model.SheetMusic;
import nl.miwnn.se14.ingeborg.musiclibrary.resources.CopyRepository;
import nl.miwnn.se14.ingeborg.musiclibrary.resources.SheetMusicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Ingeborg Frentz
 * Handling copies of sheet music
 */

@Controller
public class CopyController {

    private final SheetMusicRepository sheetMusicRepository;
    private final CopyRepository copyRepository;

    public CopyController(SheetMusicRepository sheetMusicRepository, CopyRepository copyRepository) {
        this.sheetMusicRepository = sheetMusicRepository;
        this.copyRepository = copyRepository;
    }

    @GetMapping("/copy/new/{sheetMusicId}")
    private String createNewCopy(@PathVariable("sheetMusicId") Long sheetMusicId) {
        Optional<SheetMusic> sheetMusicOptional = sheetMusicRepository.findById(sheetMusicId);

        if (sheetMusicOptional.isEmpty()) {
            System.err.printf("Could not retrieve music with ID: %d", sheetMusicId);
            return "redirect:/";
        }

        Copy copy = new Copy();
        copy.setSheetMusic(sheetMusicOptional.get());
        copyRepository.save(copy);

        return "redirect:/";
    }
}
