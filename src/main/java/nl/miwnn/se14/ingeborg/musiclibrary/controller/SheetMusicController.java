package nl.miwnn.se14.ingeborg.musiclibrary.controller;

import nl.miwnn.se14.ingeborg.musiclibrary.resources.SheetMusicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Ingeborg Frentz
 * Handle requests related to sheetmusic
 */
@Controller
public class SheetMusicController {

    private final SheetMusicRepository sheetMusicRepository;

    public SheetMusicController(SheetMusicRepository sheetMusicRepository) {
        this.sheetMusicRepository = sheetMusicRepository;
    }

    @GetMapping("/sheetmusic/overview")
    private String showSheetMusicOverview(Model datamodel) {
        datamodel.addAttribute("allSheetMusic", sheetMusicRepository.findAll());

        return "sheetMusicOverview";
    }
}
