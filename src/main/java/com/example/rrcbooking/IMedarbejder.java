//Camille
package com.example.rrcbooking;

import com.example.rrcbooking.Model.Medarbejder;

import java.util.List;


public interface IMedarbejder {

    void opretMedarbejder(Medarbejder medarbejder);

    List<Medarbejder> medarbejderListe();

    void sletMedarbejder(String maTelefonNummer);

    Medarbejder findMedarbejderTlf(String maTelefonNummer);

}
