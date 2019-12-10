package com.example.rrcbooking.Controller;

import com.example.rrcbooking.Model.Booking;
import com.example.rrcbooking.Model.Kunde;
import com.example.rrcbooking.Service.BookingService;
import com.example.rrcbooking.Service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

@Controller
public class BookingController {

    //dependency injections
    @Autowired
    BookingService bookingService;

    @GetMapping("/")
    public String Index(){
        return "index";
    }

    //opret booking
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

    //Se alt relevante booking og kunde info på udvalgt dato
   /* @GetMapping("/seBookinger/{valgtDato}")
    public String valgtBookingDato(@PathVariable("valgtDato") String valgtDato, Model model) {
        model.addAttribute("udvalgtbooking", bookingService.valgtBookingDato(valgtDato)); //denne parameter bliver tjekket fra service laget
        return "seBookinger";
    }*/

    @GetMapping("/seBookinger/{dagensDato}")
    public String seBooking(@PathVariable String dagensDato) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dato = new java.util.Date();
        dagensDato = formatter.format(dato);
        bookingService.seBooking(dagensDato);
        return "seBookinger";
    }

    //Slet
    @GetMapping("/slet/{telefonNummer}")
    public String slet(@PathVariable("telefonNummer") int telefonNummer, String dato){
        bookingService.sletBooking(telefonNummer, dato);
        return "redirect:/seBookinger";
    }

    //Opdater
    @GetMapping("/opdaterBooking/{tele1}/{dato}")
    public String opdater(@PathVariable("tele1") int telefonNummer, @PathVariable("dato") String dato, Model model){
        model.addAttribute("kunde", bookingService.findBookingTlf(telefonNummer, dato));
        return "opdaterBooking";
    }

    @PostMapping("/seBooking")
    public String opdaterNu(@ModelAttribute Kunde kunde){
        bookingService.opdaterBooking(kunde);
        System.out.println("Gemt ja1");
        return "seBookinger";
    }

}
