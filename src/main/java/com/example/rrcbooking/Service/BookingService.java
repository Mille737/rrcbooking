package com.example.rrcbooking.Service;

import com.example.rrcbooking.Model.Booking;
import com.example.rrcbooking.Model.Kunde;

import com.example.rrcbooking.Repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Date;

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
        boolean flag = true;
        if(flag) {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dato = new java.util.Date();
            String dagensDato = formatter.format(dato);
            System.out.println(dagensDato);
            return bookingRepo.valgtBookingDato(valgtDato);

        }
        flag = false;
        if(flag == false) {

            System.out.println(valgtDato + "hej");
            return bookingRepo.valgtBookingDato(valgtDato);
        } else {
            return bookingRepo.valgtBookingDato(valgtDato);
        }
    }

}
