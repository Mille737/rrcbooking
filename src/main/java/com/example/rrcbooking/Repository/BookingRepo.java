package com.example.rrcbooking.Repository;

import com.example.rrcbooking.Model.Booking;
import com.example.rrcbooking.Model.Kunde;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepo {

    @Autowired
    JdbcTemplate template;


    //Se
    public List<Kunde> bookingListe(){
        String sqlallebookinger = "SELECT * FROM Kunde INNER JOIN Booking ON Kunde.TelefonNummer = booking.Kunde_TelefonNummer";
        RowMapper<Kunde> rowMapper = new BeanPropertyRowMapper<>(Kunde.class);
        return template.query(sqlallebookinger, rowMapper);
    }

    //Opret
    public void opretBooking(Booking booking, Kunde kunde){

        String sqlBooking = "INSERT INTO booking(bookingid, dato, tid, varighed, pax, kommentar, kunde_telefonnummer) VALUES (?,?,?,?,?,?,?)";
        template.update(sqlBooking,
                booking.getBookingID(),
                booking.getDato(),
                booking.getTid(),
                booking.getVarighed(),
                booking.getPax(),
                booking.getKommentar(),
                kunde.getTelefonNummer());

    }

    //Slet
    public void sletBooking(int telefonNummer){
        String sletsql = "DELETE FROM Booking WHERE Kunde_TelefonNummer = ?";
        template.update(sletsql, telefonNummer);
    }

    //Update
    public Kunde findBookingTlf(int telefonNummer){
        String sqlfind = "SELECT * FROM Kunde INNER JOIN Booking ON Kunde.TelefonNummer = booking.Kunde_TelefonNummer WHERE Booking.Kunde_TelefonNummer = ?";
        RowMapper<Kunde> rowMapper = new BeanPropertyRowMapper<>(Kunde.class);
        return template.queryForObject(sqlfind, rowMapper, telefonNummer);
    }

    public void opdaterBooking(Kunde kunde){
        String sqlOpdater = "UPDATE Booking SET Dato = ?, Tid = ?, Varighed = ?, Pax = ?, Kommentar = ? WHERE kunde_TelefonNummer = ?";
        template.update(sqlOpdater,
                        kunde.getDato(),
                        kunde.getTid(),
                        kunde.getVarighed(),
                        kunde.getPax(),
                        kunde.getKommentar(),
                        kunde.getTelefonNummer());
        System.out.println("Gemt ja");
    }
    public List<Kunde> valgtBookingDato(String valgtDato){
        String sqlvalgtDato = "SELECT * FROM gokarteksamen.booking INNER JOIN gokarteksamen.kunde ON kunde.TelefonNummer = booking.kunde_TelefonNummer WHERE booking.Dato = ?";
        RowMapper<Kunde> rowMapper = new BeanPropertyRowMapper<>(Kunde.class);
        return template.query(sqlvalgtDato, rowMapper, valgtDato);
    }

}
