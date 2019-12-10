package com.example.rrcbooking.Controller;

import com.example.rrcbooking.Model.Kunde;
import com.example.rrcbooking.Service.BookingService;
import com.example.rrcbooking.Service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KundeController {
    //dependency injections

    @Autowired
    KundeService kundeService;

    //Opret
    @GetMapping("/opretKunde")
    public String opretKunde(){
        System.out.println();
        return "opretKunde";
    }

    @PostMapping("/opretKunde")
    public String oprettetKunde(@ModelAttribute Kunde kunde){
        kundeService.opretKunde(kunde);
        System.out.println("gemt kunde");
        return "opretBooking";
    }
    //Søg
    @GetMapping("/opdaterKunde/{telefonNummer}")
    public String søg(@PathVariable("telefonNummer") String telefonNummer, Model model) {
        model.addAttribute("sog", kundeService.søgKunde(telefonNummer));
        return "opdaterKunde";
    }
    @PostMapping("/opdaterKunde")
    public String fundetKunde(@ModelAttribute Kunde kunde) {
        kundeService.fundetKunde(kunde);
        return "opretBooking";
    }
}
