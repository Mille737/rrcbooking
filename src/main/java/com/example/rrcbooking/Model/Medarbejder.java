package com.example.rrcbooking.Model;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class Medarbejder {

    @Id @NotNull
    private String maTelefonNummer;
    @NotNull @Email
    private String maEmail;
    @NotNull
    private String maNavn;

    public Medarbejder() {
    }

    public Medarbejder(String maNavn, String maTelefonNummer, String email) {
        this.maNavn = maNavn;
        this.maTelefonNummer = maTelefonNummer;
        this.maEmail = email;
    }

    public String getMaNavn() {
        return maNavn;
    }

    public void setMaNavn(String maNavn) {
        this.maNavn = maNavn;
    }

    public String getMaTelefonNummer() {
        return maTelefonNummer;
    }

    public void setMaTelefonNummer(String maTelefonNummer) {
        this.maTelefonNummer = maTelefonNummer;
    }

    public String getMaEmail() {
        return maEmail;
    }

    public void setMaEmail(String maEmail) {
        this.maEmail = maEmail;
    }
}
