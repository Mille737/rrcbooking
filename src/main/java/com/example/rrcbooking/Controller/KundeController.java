package com.example.rrcbooking.Controller;

import com.example.rrcbooking.Model.Kunde;
import com.example.rrcbooking.Service.KundeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller //Controller gør det muligt at vis den ønkset url (html siderne)
public class KundeController {

    @Autowired
    KundeService kundeService;

    //Controller til at vise opretKunde siden
    @GetMapping("/opretKunde")
    public String opretKunde() {
        return "opretKunde";
    }

    //Controller til at gemme det indtaste kunde data på opretKunde siden
    @PostMapping("/opretKunde")
    public String oprettetKunde(@ModelAttribute Kunde kunde) {
        kundeService.opretKunde(kunde);
        return "opretBooking";
    }

    //Controller til at søge på et telefonnummer og finde den passende kunde data
    @GetMapping("/opdaterKunde/{telefonNummer}")
    public String find(@PathVariable("telefonNummer") String telefonNummer, Model model) {
        model.addAttribute("find", kundeService.findKunde(telefonNummer));
        return "opdaterKunde";
    }

    //Controller til at se den fundet kunde data og mulighed for opdatering
    @PostMapping("/opdaterKunde")
    public String fundetKunde(@ModelAttribute Kunde kunde) {
        kundeService.fundetKunde(kunde);
        return "opretBooking";
    }
}
