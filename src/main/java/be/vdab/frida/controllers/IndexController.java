package be.vdab.frida.controllers;

import be.vdab.frida.domain.Adres;
import be.vdab.frida.domain.Gemeente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Controller
@RequestMapping("/")
class IndexController {
    @GetMapping
    public ModelAndView index(@CookieValue(name="kleur", required = false) String kleur,@CookieValue(name = "reedsBezocht", required = false)
            String reedsBezocht, HttpServletResponse response) {
        DayOfWeek weekdag = LocalDate.now().getDayOfWeek();
        String openGesloten =
                weekdag == DayOfWeek.MONDAY || weekdag == DayOfWeek.THURSDAY ?
                        "gesloten" : "open";
        ModelAndView modelAndView =
                new ModelAndView("index", "openGesloten", openGesloten);
        modelAndView.addObject(
                new Adres("Grote markt", "7", new Gemeente("Brussel", 1000)));
        modelAndView.addObject("kleur",kleur);
        Cookie cookie = new Cookie("reedsBezocht", "ja");
        cookie.setMaxAge(31_536_000);
        cookie.setPath("/");
        response.addCookie(cookie);
        if (reedsBezocht != null) {
            modelAndView.addObject("reedsBezocht", true);
        }
        return modelAndView;    }
}