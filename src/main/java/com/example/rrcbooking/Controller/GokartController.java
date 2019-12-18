//Nadia og Nicolaj
package com.example.rrcbooking.Controller;

import com.example.rrcbooking.Model.Gokart;
import com.example.rrcbooking.Model.Medarbejder;
import com.example.rrcbooking.Service.GokartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class GokartController {

    @Autowired
    GokartService gokartService;

    //Se Gokarts
    @GetMapping("/seGokarts")
    public String seGokarts(Model model){
        model.addAttribute("gokartStatus", gokartService.gokartListe());
        return "seGokarts";
    }

    //Se Gokarts på værksted
    @GetMapping("/gokartsPaaVaerksted")
    public String gokartsPV(Model model){
        model.addAttribute("gokartsPV", gokartService.gokartListePaaVaerksted());
        return "gokartsPaaVaerksted";
    }

    //Opdater Gokart status
    @GetMapping("/opdaterGokarts/{GokartID}")
    public String opdaterGokartStatus(@PathVariable("GokartID") int GokartID, Model model){
        model.addAttribute("gokart", gokartService.findGokartID(GokartID));
        return "opdaterGokarts";
    }

    @PostMapping("/opdaterGokarts")
    public String opdaterGokartStatus(@ModelAttribute Gokart gokart){
        gokartService.opdaterGokartStatus(gokart);
        return "redirect:/seGokarts";
    }

}
