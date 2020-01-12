//Nadia og Nicolaj
package com.example.rrcbooking.Repository;

import com.example.rrcbooking.IBooking;
import com.example.rrcbooking.Model.Booking;
import com.example.rrcbooking.Model.Kunde;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository // Repository inholder SQL sætninger
public class BookingRepo implements IBooking {

    @Autowired
    JdbcTemplate template;

    //Opret - her oprettes der en ny booking
    public void opretBooking(Booking booking, Kunde kunde) {
        String sqlBooking = "INSERT INTO booking(bookingid, dato, tid, varighed, pax, kommentar, kunde_telefonnummer) VALUES (?,?,?,?,?,?,?)";
        template.update(sqlBooking,
                booking.getBookingID(),
                booking.getDato(),
                booking.getTid(),
                booking.getVarighed(),
                booking.getPax(),
                booking.getKommentar(),
                kunde.getTelefonnummer());
    }

    //Se - her bliver alle bookinger med udvalgt dato vist
    public List<Kunde> valgtBookingDato(String valgtDato){
        String sqlvalgtDato = "SELECT * FROM gokarteksamen.booking INNER JOIN gokarteksamen.kunde ON kunde.TelefonNummer = booking.kunde_TelefonNummer WHERE booking.Dato = ? ORDER BY Tid, Varighed";

        //RowMapper laver en instans/objekt af Kunde klassen (Som nedarver Booking).
        RowMapper<Kunde> rowMapper = new BeanPropertyRowMapper<>(Kunde.class);

        //query laver en forespørgsel om flere rækker fra databasen.
        return template.query(sqlvalgtDato, rowMapper, valgtDato);
    }

    //Opdater funktion//

    // Opdater - her finder man den ønsket booking udfra telefonnummer og dato
    public Kunde findBooking(int telefonNummer, String dato) {
        String sqlfind = "SELECT * FROM Kunde INNER JOIN Booking ON Kunde.TelefonNummer = booking.Kunde_TelefonNummer WHERE Booking.Kunde_TelefonNummer = ? AND booking.Dato = ?";

        //RowMapper laver en instans/objekt af Kunde klassen (Som nedarver Booking).
        RowMapper<Kunde> rowMapper = new BeanPropertyRowMapper<>(Kunde.class);

        //queryForObject en forespørgsel for en single row eller enkelt værdi fra databasen.
        return template.queryForObject(sqlfind, rowMapper, telefonNummer, dato);
    }

    //Opdater - her ændres booking information vis ønsket
    public void opdaterBooking(Kunde kunde) {
        String sqlOpdater = "UPDATE gokarteksamen.Booking SET Tid = ?, Varighed = ?, Pax = ?, Kommentar = ? WHERE kunde_TelefonNummer = ? AND Dato = ?";
        template.update(sqlOpdater,
                kunde.getTid(),
                kunde.getVarighed(),
                kunde.getPax(),
                kunde.getKommentar(),
                kunde.getTelefonnummer(),
                kunde.getDato());
        System.out.println("Gemt ja" + kunde.getPax());
    }

    //Slet - her slettes en allerede gemt booking
    public void sletBooking(int telefonNummer, String dato) {
        String sletsql = "DELETE FROM Booking WHERE Kunde_TelefonNummer = ? AND Dato = ?";
        template.update(sletsql, telefonNummer, dato);
    }
}
