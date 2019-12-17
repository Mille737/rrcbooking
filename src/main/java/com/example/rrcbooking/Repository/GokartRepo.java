
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

    public List<Gokart> gokartListe() {
        String sqlGokart = "SELECT * FROM Gokart WHERE Reperation = 'NEJ'";
        //String sqlTotal = "SELECT COUNT(*) FROM gokarteksamen.gokart WHERE Reperation = 'NEJ'";
        RowMapper<Gokart> rowMapper = new BeanPropertyRowMapper<>(Gokart.class);
        return template.query(sqlGokart ,rowMapper);
    }

    public List<Gokart> gokartListePaaVaerksted(){
        String sqlpaavaerksted = "SELECT * FROM Gokart WHERE Reperation = 'JA'";
        RowMapper<Gokart> rowMapper = new BeanPropertyRowMapper<>(Gokart.class);
        return template.query(sqlpaavaerksted, rowMapper);
    }

    //Opdater gokart status
    public Gokart findGokartID(int GokartID){
        String sqlFindGokartID = "SELECT * FROM Gokart WHERE GokartID = ?";
        RowMapper<Gokart> rowMapper = new BeanPropertyRowMapper<>(Gokart.class);
        return template.queryForObject(sqlFindGokartID, rowMapper, GokartID);
    }

    public void opdaterGokartStatus(Gokart gokart){
        String sqlOpdaterGokartStatus = "UPDATE gokart SET Reperation = ? WHERE GokartID = ?";
        template.update(sqlOpdaterGokartStatus, gokart.getReperation(), gokart.getGokartID());
    }

}
