package com.example.rrcbooking.Repository;

import com.example.rrcbooking.Model.Kunde;
import com.example.rrcbooking.Model.Medarbejder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedarbejderRepo {

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
        RowMapper<Medarbejder> rowMapper = new BeanPropertyRowMapper<>(Medarbejder.class);
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
        RowMapper<Medarbejder> rowMapper = new BeanPropertyRowMapper<>(Medarbejder.class);
        return template.queryForObject(sqlFind, rowMapper, maTelefonNummer);
    }

    public void opdaterMedarbejder(Medarbejder medarbejder){

        String sqlOpdater = "UPDATE medarbejder SET maEmail = ?, maNavn = ? WHERE maTelefonNummer=?";
        template.update(sqlOpdater, medarbejder.getMaEmail(), medarbejder.getMaNavn(), medarbejder.getMaTelefonNummer());
        System.out.println("opdateret medarbejder");
    }

}
