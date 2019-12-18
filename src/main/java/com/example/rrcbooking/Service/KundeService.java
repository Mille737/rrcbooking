//Camille og Christian
package com.example.rrcbooking.Service;

import com.example.rrcbooking.IKunde;
import com.example.rrcbooking.Model.Kunde;
import com.example.rrcbooking.Repository.KundeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service // det er i dette lag hvor man ville sætter fx. java udregninger ind
public class KundeService implements IKunde {

    @Autowired
    KundeRepo kundeRepo;

    //Opret - her kaldes opret methoden fra repository laget
    public void opretKunde(Kunde kunde) {
        kundeRepo.opretKunde(kunde);
    }

    //Find kunde- her kaldes findKunde methoden fra repository laget
    public List<Kunde> findKunde(String telefonNummer) {
        return kundeRepo.findKunde(telefonNummer);
    }

    //Fundet kunde- her kaldes fundetKunde methoden fra repository laget
    public void fundetKunde(Kunde kunde) {
        kundeRepo.fundetKunde(kunde);
    }

}
