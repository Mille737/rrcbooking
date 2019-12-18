//Camille
package com.example.rrcbooking;

import com.example.rrcbooking.Model.Kunde;

import java.util.List;


public interface IKunde {

    void opretKunde(Kunde kunde);

    List<Kunde> findKunde(String telefonNummer);

    void fundetKunde(Kunde kunde);
}
