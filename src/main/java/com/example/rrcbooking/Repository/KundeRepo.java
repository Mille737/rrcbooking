//Camille og Christian
package com.example.rrcbooking.Repository;

import com.example.rrcbooking.IKunde;
import com.example.rrcbooking.Model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository // Repository inholder SQL sætninger
public class KundeRepo implements IKunde {


    @Autowired
    JdbcTemplate template;

    ///Opret - her oprettes der en ny kunde
    public void opretKunde(Kunde kunde) {
        String sqlKunde = "INSERT INTO kunde(navn, telefonnummer, email, firmaNavn) VALUES (?,?,?,?)";
        template.update(sqlKunde,
                kunde.getNavn(),
                kunde.getTelefonnummer(),
                kunde.getEmail(),
                kunde.getFirmaNavn());
    }

    //Find oensket kunde med tilhoerende telefonnummer
    public List<Kunde> findKunde(String telefonNummer) {
        String soegsql = "SELECT * FROM Kunde WHERE TelefonNummer = ?";

        //RowMapper laver en instans/objekt af Kunde klassen (Som nedarver Booking).
        RowMapper<Kunde> rowMapper = new BeanPropertyRowMapper<>(Kunde.class);

        //query laver en forespørgsel om flere rækker fra databasen.
        return template.query(soegsql, rowMapper, telefonNummer);
    }

    //Fundet kunden med indtastet telefonnummer
    public void fundetKunde(Kunde kunde) {
        String sqlOpdater = "UPDATE Kunde SET Navn = ?, Email = ?, FirmaNavn = ? WHERE TelefonNummer = ?";
        template.update(sqlOpdater,
                kunde.getNavn(),
                kunde.getEmail(),
                kunde.getFirmaNavn(),
                kunde.getTelefonnummer());
    }
}
