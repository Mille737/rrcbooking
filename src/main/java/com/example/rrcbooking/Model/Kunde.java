package com.example.rrcbooking.Model;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


public class Kunde extends Booking{

    @Id @NotNull
    private String navn;
    @NotNull @Email
    private String email;
    private String firmaNavn;
    @NotNull
    private String telefonnummer;


    public Kunde() {
    }

    public Kunde(String navn, String email, String firmaNavn, String telefonnummer) {
        this.navn = navn;
        this.email = email;
        this.firmaNavn = firmaNavn;
        this.telefonnummer = telefonnummer;
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

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
}

