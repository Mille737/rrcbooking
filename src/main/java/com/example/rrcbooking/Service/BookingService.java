package com.example.rrcbooking.Service;

import com.example.rrcbooking.Model.Booking;
import com.example.rrcbooking.Model.Kunde;

import com.example.rrcbooking.Repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepo bookingRepo;

    //Opret
    public void opretBooking(Booking booking, Kunde kunde){
        bookingRepo.opretBooking(booking, kunde);
    }

    public List<Kunde> bookingList(){
        return bookingRepo.bookingListe();
    }

    //Slet
    public void sletBooking(int telefonNummer){
        bookingRepo.sletBooking(telefonNummer);
    }

    //Opdater
    public Kunde findBookingTlf(int telefonNummer){
        return bookingRepo.findBookingTlf(telefonNummer);
    }

    public void opdaterBooking(Kunde kunde){
        bookingRepo.opdaterBooking(kunde);
    }

}
