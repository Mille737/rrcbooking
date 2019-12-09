package com.example.rrcbooking.Service;

import com.example.rrcbooking.Model.Booking;
import com.example.rrcbooking.Model.Kunde;

import com.example.rrcbooking.Repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepo bookingRepo;

    //Opret
    public void opretBooking(Booking booking, Kunde kunde){
        bookingRepo.opretBooking(booking, kunde);
    }
    //se
    public List<Kunde> bookingList(){
        return bookingRepo.bookingListe();
    }


    //Slet
    public void sletBooking(int telefonNummer, String dato){
        bookingRepo.sletBooking(telefonNummer, dato);
    }

    //Opdater
    public Kunde findBookingTlf(int telefonNummer, String dato){
        return bookingRepo.findBookingTlf(telefonNummer, dato);
    }

    public void opdaterBooking(Kunde kunde){
        bookingRepo.opdaterBooking(kunde);
    }

    // find booking på valgt dato
    public List<Kunde> valgtBookingDato(String valgtDato) {
        return bookingRepo.valgtBookingDato(valgtDato);
    }

}
