package com.example.rrcbooking.Model;

import javax.persistence.Id;

public class Medarbejder {

    @Id
    private int maTelefonNummer;
    private String maEmail;
    private String maNavn;

    public Medarbejder() {
    }

    public Medarbejder(String maNavn, int maTelefonNummer, String email) {
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

    public int getMaTelefonNummer() {
        return maTelefonNummer;
    }

    public void setMaTelefonNummer(int maTelefonNummer) {
        this.maTelefonNummer = maTelefonNummer;
    }

    public String getMaEmail() {
        return maEmail;
    }

    public void setMaEmail(String maEmail) {
        this.maEmail = maEmail;
    }
}
