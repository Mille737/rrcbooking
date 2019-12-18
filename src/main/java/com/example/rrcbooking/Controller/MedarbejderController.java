//Camille og Christian
package com.example.rrcbooking.Controller;

import com.example.rrcbooking.Model.Medarbejder;
import com.example.rrcbooking.Service.MedarbejderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MedarbejderController {

    @Autowired
    MedarbejderService medarbejderService;

    //Opret
    @GetMapping("/opretMedarbejder")
    public String opretMedarbejder(){
        System.out.println();
        return "opretMedarbejder";
    }

    @PostMapping("/opretMedarbejder")
    public String oprettetMedarbejder(@ModelAttribute Medarbejder medarbejder){
        medarbejderService.opretMedarbejder(medarbejder);
        System.out.println("gemt medarbejder");
        return "redirect:/seMedarbejder";
    }

    //Se
    @GetMapping("/seMedarbejder")
    public String seMedarbejder(Model model){
        model.addAttribute("medarbejderInfo", medarbejderService.medarbejderListe());
        return "seMedarbejder";
    }

    //Slet
    @GetMapping("/sletMedarbejder/{maTelefonNummer}")
    public String slet(@PathVariable("maTelefonNummer") String maTelefonNummer){
        medarbejderService.sletMedarbejder(maTelefonNummer);
        return "redirect:/seMedarbejder";
    }

    //Opdater
    @GetMapping("/opdaterMedarbejder/{maTelefonNummer}")
    public String opdaterMedarbejder(@PathVariable("maTelefonNummer") String maTelefonNummer, Model model){
        model.addAttribute("medarbejder", medarbejderService.findMedarbejderTlf(maTelefonNummer));
        System.out.println("test");
        return "opdaterMedarbejder";
    }

    @PostMapping("/opdaterMedarbejder")
    public String opdaterNuMedarbejder(@ModelAttribute Medarbejder medarbejder){
        medarbejderService.opdaterMedarbejder(medarbejder);
        System.out.println("test medarbejder opdateret");
        return "redirect:/seMedarbejder";
    }
}
