//Nadia og Nicolaj
package com.example.rrcbooking.Controller;

import com.example.rrcbooking.Model.Booking;
import com.example.rrcbooking.Model.Kunde;
import com.example.rrcbooking.Service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller //Controller goer det muligt at vis den oenkset url (html siderne)
public class BookingController {

    @Autowired
    BookingService bookingService;

    //Controller til index siden som er vores start side
    @GetMapping("/")
    public String Index(){
        return "index";
    }

    //Controller til at vise opretBooking siden
    @GetMapping("/opretBooking")
    public String opretBooking(){
        return "opretBooking";
    }

    //Controller til at gemme det indtaste booking data paa opretBooking siden
    @PostMapping("/opretBooking")
    //@ModelAttribute binder værdier fra inputfields til objektet.
    public String oprettetBooking(@ModelAttribute Booking booking, Kunde kunde) {
        bookingService.opretBooking(booking, kunde);
        return "redirect:/seBookinger" + "/" + kunde.getDato();
    }

    //Controller til seBooking siden
    @GetMapping("/seBookinger")
    public String seBooking() {
        return "seBookinger";
    }

    //Controller til at se alle valgte booking og kunde info paa udvalgt dato
    @GetMapping("/seBookinger/{valgtDato}")
    //@PathVariable henter værdien fra "valgtDato" til URI
    public String valgtBookingDato(@PathVariable("valgtDato") String valgtDato, Model model) {
        model.addAttribute("udvalgtbooking", bookingService.valgtBookingDato(valgtDato)); //denne parameter bliver tjekket fra service laget
        return "seBookinger";
    }

    //Controller til at opdater booking med det tilhoerende telefonnummer og dato
    @GetMapping("/opdaterBooking/{telefonnummer}/{dato}")//URI
    //@PathVariable henter værdien fra "telefonnummer og dato" til URI
    public String opdater(@PathVariable("telefonnummer") int telefonNummer, @PathVariable("dato") String dato, Model model) {
        model.addAttribute("kunde", bookingService.findBooking(telefonNummer, dato));
        return "opdaterBooking";
    }

    //Controller til at gemme dataen efter aendringerne
    @PostMapping("/opdaterBooking")
    //@ModelAttribute binder værdier fra inputfields til objektet.
    public String opdaterNu(@ModelAttribute Kunde kunde) {
        bookingService.opdaterBooking(kunde);
        return "redirect:/seBookinger/" + kunde.getDato();
    }

    //Controller til slet booking med det tilhoerende telefonnummer og dato
    @GetMapping("/slet/{telefonnummer}/{dato}")
    //@ModelAttribute binder værdier fra inputfields til objektet.
    //@PathVariable henter værdien fra "telefonnummer og dato" til URI
    public String slet(@ModelAttribute Kunde kunde, @PathVariable("telefonnummer") int telefonnummer, @PathVariable("dato") String dato) {
        bookingService.sletBooking(telefonnummer, dato);
        return "redirect:/seBookinger/" + kunde.getDato();
    }
}