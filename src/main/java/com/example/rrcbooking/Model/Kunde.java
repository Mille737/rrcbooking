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
    private String tele1;


    public Kunde() {
    }

    public Kunde(String telefonNummer, String navn, String email, String firmaNavn, Booking booking, String tele1) {
        this.telefonNummer = telefonNummer;
        this.navn = navn;
        this.email = email;
        this.firmaNavn = firmaNavn;
        this.booking = new Booking(getBookingID(),getDato(),getTid(),getVarighed(),getPax(),getKommentar());
        this.tele1 = tele1;
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

    public String getTele1() {
        return tele1;
    }

    public void setTele1(String tele1) {
        this.tele1 = tele1;
    }
}


