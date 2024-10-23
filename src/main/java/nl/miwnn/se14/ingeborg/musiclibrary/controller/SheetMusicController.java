package nl.miwnn.se14.ingeborg.musiclibrary.controller;

import nl.miwnn.se14.ingeborg.musiclibrary.model.SheetMusic;
import nl.miwnn.se14.ingeborg.musiclibrary.resources.SheetMusicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping({"/", "/sheetmusic/overview"})
    private String showSheetMusicOverview(Model datamodel) {
        datamodel.addAttribute("allSheetMusic", sheetMusicRepository.findAll());

        return "sheetMusicOverview";
    }

    @GetMapping("/sheetmusic/new")
    private String showSheetMusicForm(Model datamodel) {
        datamodel.addAttribute("newSheetMusic", new SheetMusic());

        return "sheetMusicForm";
    }

    @PostMapping("/sheetmusic/new")
    private String saveOrUpdateSheetMusic(@ModelAttribute("newSheetMusic") SheetMusic sheetMusicToBeSaved,
                                          BindingResult result) {
        if (result.hasErrors()) {
            System.err.println(result.getAllErrors());
            return "redirect:/sheetmusic/overview";
        }

        sheetMusicRepository.save(sheetMusicToBeSaved);
        return "redirect:/sheetmusic/overview";
    }

    @GetMapping("/sheetmusic/delete/{sheetMusicId}")
    private String deleteSheetMusic(@PathVariable("sheetMusicId") Long sheetMusicId) {
        sheetMusicRepository.deleteById(sheetMusicId);
        return "redirect:/sheetmusic/overview";
    }
}
