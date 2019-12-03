package com.example.rrcbooking.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Kunde extends Booking{

    @Id
    private String telefonNummer;
    private String navn;
    private String email;
    private String firmaNavn;
    private Booking booking;


    public Kunde() {
    }

    public Kunde(String telefonNummer, String navn, String email, String firmaNavn, Booking booking) {
        this.telefonNummer = telefonNummer;
        this.navn = navn;
        this.email = email;
        this.firmaNavn = firmaNavn;
        this.booking = new Booking(getBookingID(),getDato(),getTid(),getVarighed(),getPax(),getKommentar());

    }

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(String telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public void setFirmaNavn(String firmaNavn) {
        this.firmaNavn = firmaNavn;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}


