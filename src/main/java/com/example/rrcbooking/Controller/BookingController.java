package com.example.rrcbooking.Controller;

import com.example.rrcbooking.Model.Booking;
import com.example.rrcbooking.Model.Kunde;
import com.example.rrcbooking.Service.BookingService;
import com.example.rrcbooking.Service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

    //dependency injections
    @Autowired
    BookingService bookingService;

    @Autowired
    KundeService kundeService;

    @GetMapping("/")
    public String Index(){
        return "index";
    }

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

    @GetMapping("/opretBooking")
    public String opretBooking(){
        return "opretBooking";
    }

    @PostMapping("/opretBooking")
    public String oprettetBooking(@ModelAttribute Booking booking, Kunde kunde){
        bookingService.opretBooking(booking, kunde);
        System.out.println("Gemt booking");
        return "redirect:/";
    }

    //Se
    @GetMapping("/seBookinger")
    public String seBookinger(Model model){
        model.addAttribute("samletBookinger", bookingService.bookingList());
        return "seBookinger";
    }

    //Slet
    @GetMapping("/slet/{telefonNummer}")
    public String slet(@PathVariable("telefonNummer") int telefonNummer){
        bookingService.sletBooking(telefonNummer);
        return "redirect:/seBookinger";
    }

    //Søg
    @GetMapping(value = "kunder")
    public String søg(@RequestParam(value = "telefonNummer", required = false) String telefonNummer, Model model) {
        model.addAttribute("search", kundeService.søgKunde(telefonNummer));
        return "opretBookinger";
    }

    //Opdater
    @GetMapping("/opdaterBooking/{telefonNummer}")
    public String opdater(@PathVariable("telefonNummer") int telefonNummer, Model model){
        model.addAttribute("kunde", bookingService.findBookingTlf(telefonNummer));
        return "opdaterBooking";
    }

    @PostMapping("/opdaterBooking")
    public String opdaterNu(@ModelAttribute Kunde kunde){
        bookingService.opdaterBooking(kunde);
        System.out.println("Gemt ja1");
        return "redirect:/seBookinger";
    }


    //vis bookinger med valgte dato
    @GetMapping("/dagensDato/{valgtDato}")
    public String valgtBookingDato(@PathVariable("valgtDato") String vd, Model model) {
        model.addAttribute("udvalgtbooking", bookingService.valgtBookingDato(vd));
        return "dagensDato";
    }

    // søg booking via dato
    @PostMapping("/dagensDato/{valgtDato}")
    public String findDato(){
        return "dagensDato";
    }
}
