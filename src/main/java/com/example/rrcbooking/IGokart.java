package com.example.rrcbooking;

import com.example.rrcbooking.Model.Gokart;

import java.util.List;

public interface IGokart {

    List<Gokart> gokartListe();

    List<Gokart> gokartListePaaVaerksted();

    Gokart findGokartID(int GokartID);

    void opdaterGokartStatus(Gokart gokart);
}
