//Nadia og Nicolaj
package com.example.rrcbooking.Repository;

import com.example.rrcbooking.IGokart;
import com.example.rrcbooking.Model.Gokart;
import com.example.rrcbooking.Model.Medarbejder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class GokartRepo implements IGokart {

    @Autowired
    JdbcTemplate template;

    //Se gokarts som ikke er på værksted
    public List<Gokart> gokartListe() {
        String sqlGokart = "SELECT * FROM Gokart WHERE Reperation = 'NEJ'";

        //RowMapper laver en instans/objekt af Gokart klassen.
        RowMapper<Gokart> rowMapper = new BeanPropertyRowMapper<>(Gokart.class);

        //query laver en forespørgsel om flere rækker fra databasen.
        return template.query(sqlGokart ,rowMapper);
    }

    //Se gokarts som er på værksted
    public List<Gokart> gokartListePaaVaerksted(){
        String sqlpaavaerksted = "SELECT * FROM Gokart WHERE Reperation = 'JA'";

        //RowMapper laver en instans/objekt af Gokart klassen.
        RowMapper<Gokart> rowMapper = new BeanPropertyRowMapper<>(Gokart.class);

        //query laver en forespørgsel om flere rækker fra databasen.
        return template.query(sqlpaavaerksted, rowMapper);
    }

    //Opdater gokart status
    public Gokart findGokartID(int GokartID){
        String sqlFindGokartID = "SELECT * FROM Gokart WHERE GokartID = ?";

        //RowMapper laver en instans/objekt af Gokart klassen
        RowMapper<Gokart> rowMapper = new BeanPropertyRowMapper<>(Gokart.class);

        //queryForObject en forespørgsel for en single row eller enkelt værdi fra databasen.
        return template.queryForObject(sqlFindGokartID, rowMapper, GokartID);
    }

    public void opdaterGokartStatus(Gokart gokart){
        String sqlOpdaterGokartStatus = "UPDATE gokart SET Reperation = ? WHERE GokartID = ?";
        template.update(sqlOpdaterGokartStatus, gokart.getReperation(), gokart.getGokartID());
    }

}
