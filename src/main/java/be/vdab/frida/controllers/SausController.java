package be.vdab.frida.controllers;

import be.vdab.frida.domain.Saus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("sauzen")
class SausController {
    private final Saus[] sauzen = {
            new Saus(1L, "Cocktail",
                    new String[] {"Mayonaise","Tomatenketchup","whiskey","cayenne peper"}),
            new Saus(2L, "Mayonaise",
                    new String[] {"eidooier","citroensap","olie","zout","peper"}),
            new Saus(3L, "Mosterd",
                    new String[] {"mosterdzaad","water","zout","azijn"}),
            new Saus(4L, "Tartare",
                    new String[] {"ei","mayonaise","kappertjes","augurk","dragon"}),
            new Saus(5L, "Vinaigrette",
                    new String[] {"olie","water","zout","azijn"})};

    @GetMapping
    public ModelAndView sauzen() {
        return new ModelAndView("sauzen", "sauzen", sauzen);
    }
}

