package com.example.rrcbooking.Model;


import javax.persistence.Entity;
import javax.persistence.Id;

public class Booking {

    @Id
    private int bookingID;
    private String dato;
    private String tid;
    private int varighed;
    private int pax;
    private String kommentar;
    private String testtesttet;

    public Booking() {
    }

    public Booking(int bookingID, String dato, String tid, int varighed, int pax, String kommentar) {
        this.bookingID = bookingID;
        this.dato = dato;
        this.tid = tid;
        this.varighed = varighed;
        this.pax = pax;
        this.kommentar = kommentar;
    }


    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getVarighed() {
        return varighed;
    }

    public void setVarighed(int varighed) {
        this.varighed = varighed;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

}
