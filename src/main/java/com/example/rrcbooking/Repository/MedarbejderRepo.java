//Camille og Christian
package com.example.rrcbooking.Repository;

import com.example.rrcbooking.IMedarbejder;
import com.example.rrcbooking.Model.Medarbejder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MedarbejderRepo implements IMedarbejder {

    @Autowired
    JdbcTemplate template;

    //Opret
    public void opretMedarbejder(Medarbejder medarbejder) {
        String sqlMedarbejder = "INSERT INTO medarbejder(maTelefonNummer, maEmail, maNavn) VALUES (?,?,?)";
        template.update(sqlMedarbejder,
                medarbejder.getMaTelefonNummer(),
                medarbejder.getMaEmail(),
                medarbejder.getMaNavn());
    }

    //Se
    public List<Medarbejder> medarbejderListe(){
        String sqlalle = "SELECT * FROM medarbejder";

        //RowMapper laver en instans/objekt af Medarbejder klassen.
        RowMapper<Medarbejder> rowMapper = new BeanPropertyRowMapper<>(Medarbejder.class);

        //query laver en forespørgsel om flere rækker fra databasen.
        return template.query(sqlalle, rowMapper);
    }

    //slet
    public void sletMedarbejder(String maTelefonNummer) {
        String sletsql = "DELETE FROM medarbejder WHERE maTelefonNummer=?";
        template.update(sletsql, maTelefonNummer);
    }

    //Update
    public Medarbejder findMedarbejderTlf(String maTelefonNummer){
        String sqlFind = "SELECT * FROM medarbejder WHERE maTelefonNummer = ?";

        //RowMapper laver en instans/objekt af Medarbejder klassen.
        RowMapper<Medarbejder> rowMapper = new BeanPropertyRowMapper<>(Medarbejder.class);

        //queryForObject en forespørgsel for en single row eller enkelt værdi fra databasen.
        return template.queryForObject(sqlFind, rowMapper, maTelefonNummer);
    }

    public void opdaterMedarbejder(Medarbejder medarbejder){

        String sqlOpdater = "UPDATE medarbejder SET maEmail = ?, maNavn = ? WHERE maTelefonNummer=?";
        template.update(sqlOpdater, medarbejder.getMaEmail(), medarbejder.getMaNavn(), medarbejder.getMaTelefonNummer());
        System.out.println("opdateret medarbejder");
    }

}
