package be.vdab.frida.controllers;

import be.vdab.frida.domain.Saus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequestMapping("sauzen")
class SausController {
    private final Saus[] sauzen = {
            new Saus(1L, "cocktail",
                    new String[] {"mayonaise","tomatenketchup","whiskey","cayenne peper"}),
            new Saus(2L, "mayonaise",
                    new String[] {"eidooier","citroensap","olie","zout","peper"}),
            new Saus(3L, "mosterd",
                    new String[] {"mosterdzaad","water","zout","azijn"}),
            new Saus(4L, "tartare",
                    new String[] {"ei","mayonaise","kappertjes","augurk","dragon"}),
            new Saus(5L, "vinaigrette",
                    new String[] {"olie","water","zout","azijn"})};

    @GetMapping
    public ModelAndView sauzen() {
        return new ModelAndView("sauzen", "sauzen", sauzen);
    }
    @GetMapping("{nummer}")
    public ModelAndView saus(@PathVariable long nummer) {
        ModelAndView modelAndView = new ModelAndView("saus");
        Arrays.stream(sauzen)
                .filter(saus -> saus.getNummer() == nummer)
                .findFirst()
                .ifPresent(saus -> modelAndView.addObject(saus));
        return modelAndView;
    }
}

