package nl.miwnn.se14.ingeborg.musiclibrary.controller;

import nl.miwnn.se14.ingeborg.musiclibrary.model.Instrument;
import nl.miwnn.se14.ingeborg.musiclibrary.model.InstrumentCopy;
import nl.miwnn.se14.ingeborg.musiclibrary.resources.InstrumentCopyRepository;
import nl.miwnn.se14.ingeborg.musiclibrary.resources.InstrumentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Ingeborg Frentz
 * Handle requests made of multiples of instruments
 */

@Controller
public class InstrumentCopyController {
    private final InstrumentRepository instrumentRepository;
    private final InstrumentCopyRepository instrumentCopyRepository;

    public InstrumentCopyController(InstrumentRepository instrumentRepository,
                                    InstrumentCopyRepository instrumentCopyRepository) {
        this.instrumentRepository = instrumentRepository;
        this.instrumentCopyRepository = instrumentCopyRepository;
    }

    @GetMapping("/instrumentcopy/new/{instrumentId}")
    private String createNewInstrumentCopy(@PathVariable("instrumentId") Long instrumentId) {
        Optional<Instrument> instrumentOptional = instrumentRepository.findById(instrumentId);

        if (instrumentOptional.isEmpty()) {
            System.err.printf("Could not retrieve instrument with ID: %d", instrumentId);
            return "redirect:/";
        }

        InstrumentCopy instrumentCopy = new InstrumentCopy();
        instrumentCopy.setInstrument(instrumentOptional.get());
        instrumentCopyRepository.save(instrumentCopy);

        return "redirect:/";
    }
}
