package nl.miwnn.se14.ingeborg.musiclibrary.controller;

import nl.miwnn.se14.ingeborg.musiclibrary.model.Instrument;
import nl.miwnn.se14.ingeborg.musiclibrary.model.SheetMusic;
import nl.miwnn.se14.ingeborg.musiclibrary.resources.InstrumentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ingeborg Frentz
 * Handling everything related to instruments
 */

@Controller
@RequestMapping("/instrument")
public class InstrumentController {
    private final InstrumentRepository instrumentRepository;

    public InstrumentController(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    @GetMapping("/overview")
    private String showInstrumentOverview(Model datamodel) {
        datamodel.addAttribute("allInstruments", instrumentRepository.findAll());

        return "InstrumentOverview";
    }

    @GetMapping("/new")
    private String showInstrumentForm(Model datamodel) {
        datamodel.addAttribute("newInstrument", new Instrument());

        return "InstrumentForm";
    }

    @PostMapping("/new")
    private String saveOrUpdateInstrument(@ModelAttribute("newInstrument") Instrument instrumentToBeSaved,
                                          BindingResult result) {
        if (result.hasErrors()) {
            System.err.println(result.getAllErrors());
            return "redirect:/instrument/overview";
        }

        instrumentRepository.save(instrumentToBeSaved);
        return "redirect:/instrument/overview";
    }

    @GetMapping("/instrument/delete/{instrumentId}")
    private String deleteInstrument(@PathVariable("instrumentId") Long instrumentId) {
        instrumentRepository.deleteById(instrumentId);
        return "redirect:/instrument/overview";
    }
}
