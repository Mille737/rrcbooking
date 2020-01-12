//Camille
package com.example.rrcbooking;

import com.example.rrcbooking.Model.Booking;
import com.example.rrcbooking.Model.Kunde;

import java.util.List;


public interface IBooking {

    void opretBooking(Booking booking, Kunde kunde);

    List<Kunde> valgtBookingDato(String valgtDato);

    Kunde findBooking(int telefonNummer, String dato);

    void opdaterBooking(Kunde kunde);

    void sletBooking(int telefonNummer, String dato);
}
