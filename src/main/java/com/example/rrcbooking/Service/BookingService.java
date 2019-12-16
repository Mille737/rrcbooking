package com.example.rrcbooking.Service;

import com.example.rrcbooking.Model.Booking;
import com.example.rrcbooking.Model.Kunde;

import com.example.rrcbooking.Repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service // det er i dette lag hvor man ville sætter fx. java udregninger ind
public class BookingService {

    @Autowired
    BookingRepo bookingRepo;

    //Opret - her kaldes opret methoden fra repository laget
    public void opretBooking(Booking booking, Kunde kunde){
        bookingRepo.opretBooking(booking, kunde);
    }

    //Se - her kaldes se methoden fra repository laget
    public List<Kunde> valgtBookingDato(String valgtDato) {

        return bookingRepo.valgtBookingDato(valgtDato);
    }

    //Opdater - her kaldes de to opdater methoder fra repository laget
    public Kunde findBooking(int telefonNummer, String dato){
        return bookingRepo.findBooking(telefonNummer, dato);
    }

    public void opdaterBooking(Kunde kunde){
        bookingRepo.opdaterBooking(kunde);
    }

    //Slet - her kaldes slet methoden fra repository laget
    public void sletBooking(int telefonNummer, String dato){
        bookingRepo.sletBooking(telefonNummer, dato);
    }
}



