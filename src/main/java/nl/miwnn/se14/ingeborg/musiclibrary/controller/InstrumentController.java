package nl.miwnn.se14.ingeborg.musiclibrary.controller;

import nl.miwnn.se14.ingeborg.musiclibrary.model.Instrument;
import nl.miwnn.se14.ingeborg.musiclibrary.resources.InstrumentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ingeborg Frentz
 * Handling instrumentation related to music
 */

@Controller
@RequestMapping("/instrument")
public class InstrumentController {
    private final InstrumentRepository instrumentRepository;

    public InstrumentController(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    @GetMapping("/overview")
    private String showInstrumentationOverview(Model datamodel) {
        datamodel.addAttribute("allInstruments", instrumentRepository.findAll());
        datamodel.addAttribute("newInstrument", new Instrument());

        return "instrumentOverview";
    }

    @PostMapping("/new")
    private String saveOrUpdateInstrument(@ModelAttribute("newInstrument") Instrument instrument,
                                          BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/instrument/overview";
        }

        instrumentRepository.save(instrument);
        return "redirect:/instrument/overview";
    }
}
