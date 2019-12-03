package com.example.rrcbooking.Repository;

import com.example.rrcbooking.Model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KundeRepo {

    @Autowired
    JdbcTemplate template;

    //Se
    public List<Kunde> kundeListe(){
        String sqlalle = "SELECT * FROM kunde";
        RowMapper<Kunde> rowMapper = new BeanPropertyRowMapper<>(Kunde.class);
        return template.query(sqlalle, rowMapper);
    }

    //Opret
    public void opretKunde(Kunde kunde){
        String sqlKunde = "INSERT INTO kunde(telefonNummer, navn, email, firmaNavn) VALUES (?,?,?,?)";
        template.update(sqlKunde,
                kunde.getTelefonNummer(),
                kunde.getNavn(),
                kunde.getEmail(),
                kunde.getFirmaNavn());
    }

    //søg VIRKER IKKE ENDNU!!
    public Kunde søgKunde(String telefonNummer){
        String søgsql = "SELECT * FROM Kunde WHERE TelefonNummer = ?";
        RowMapper<Kunde> rowMapper = new BeanPropertyRowMapper<>(Kunde.class);
        return template.queryForObject(søgsql, rowMapper, telefonNummer);
    }
}
