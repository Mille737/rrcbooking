package com.example.rrcbooking.Repository;

import com.example.rrcbooking.Model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Repository inholder SQL sætninger
public class KundeRepo {

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

    //Find ønsket kunde med tilhørende telefonnummer
    public List<Kunde> findKunde(String telefonNummer) {
        String søgsql = "SELECT * FROM Kunde WHERE TelefonNummer = ?";
        RowMapper<Kunde> rowMapper = new BeanPropertyRowMapper<>(Kunde.class);
        return template.query(søgsql, rowMapper, telefonNummer);
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
