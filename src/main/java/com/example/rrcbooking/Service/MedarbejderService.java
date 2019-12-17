package com.example.rrcbooking.Service;

import com.example.rrcbooking.IMedarbejder;
import com.example.rrcbooking.Model.Kunde;
import com.example.rrcbooking.Model.Medarbejder;
import com.example.rrcbooking.Repository.MedarbejderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedarbejderService implements IMedarbejder {

    @Autowired
    MedarbejderRepo medarbejderRepo;

    //Opret
    public void opretMedarbejder(Medarbejder medarbejder) {
        medarbejderRepo.opretMedarbejder(medarbejder);
    }

    public List<Medarbejder> medarbejderListe() {
        return medarbejderRepo.medarbejderListe();
    }
    //slet
    public void sletMedarbejder(String maTelefonNummer){
        medarbejderRepo.sletMedarbejder(maTelefonNummer);
    }

    //Opdater
    public Medarbejder findMedarbejderTlf(String maTelefonNummer){
        return medarbejderRepo.findMedarbejderTlf(maTelefonNummer);
    }

    public void opdaterMedarbejder(Medarbejder medarbejder){
        medarbejderRepo.opdaterMedarbejder(medarbejder);
    }

}
