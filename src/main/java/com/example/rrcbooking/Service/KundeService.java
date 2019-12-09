package com.example.rrcbooking.Service;

import com.example.rrcbooking.Model.Kunde;
import com.example.rrcbooking.Repository.KundeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KundeService {

    @Autowired
    KundeRepo kundeRepo;

    //Opret
    public void opretKunde(Kunde kunde){
        kundeRepo.opretKunde(kunde);
    }

    public List<Kunde> kundeList(){
        return kundeRepo.kundeListe();
    }

    //Søg på kunde via telefonnummer
    public List<Kunde> søgKunde(String telefonNummer){
        return kundeRepo.søgKunde(telefonNummer);
    }

    //fundetKunde
    public void fundetKunde(Kunde kunde) {
        kundeRepo.fundetKunde(kunde);
    }

}
