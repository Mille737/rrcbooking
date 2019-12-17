package com.example.rrcbooking.Service;


import com.example.rrcbooking.IGokart;
import com.example.rrcbooking.Model.Gokart;
import com.example.rrcbooking.Model.Medarbejder;
import com.example.rrcbooking.Repository.GokartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GokartService implements IGokart {

    @Autowired
    GokartRepo gokartRepo;

    public List<Gokart> gokartListe(){
        return gokartRepo.gokartListe();
    }

    public List<Gokart> gokartListePaaVaerksted(){
        return gokartRepo.gokartListePaaVaerksted();
    }

    //Opdater gokart status
    public Gokart findGokartID(int GokartID){
        return gokartRepo.findGokartID(GokartID);
    }

    public void opdaterGokartStatus(Gokart gokart){
        gokartRepo.opdaterGokartStatus(gokart);
    }
}
