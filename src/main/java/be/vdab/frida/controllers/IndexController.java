package be.vdab.frida.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;

// enkele imports
@RestController
@RequestMapping("/")
class IndexController {
    @GetMapping
    public String index() {
        DayOfWeek weekdag = LocalDate.now().getDayOfWeek();
        return new StringBuffer("<!doctype html><html><title>Hallo</title><body>")
                .append(weekdag == DayOfWeek.MONDAY || weekdag == DayOfWeek.THURSDAY ?
                        "gesloten" : "open")
                .append("</body></html>")
                .toString();
    }
}