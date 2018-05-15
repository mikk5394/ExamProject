package com.example.demo.Controllers;

//import com.example.demo.Interfaces.VareRepositoryInterface;
import com.example.demo.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class VareController {

    private ArrayList<Item> vareListe = new ArrayList<>();
    private ArrayList<Item> reservationsListe = new ArrayList<>();

    @GetMapping("/")
        public String index(){
        //Hard-code varer
        // int id, String navn, String beskrivelse, int pris, String mål, String type, int antal
        if(vareListe.size() == 0) {
            vareListe.add(new Item(1, "Hans1", "Narkoman", 5000, "Lang", "Lort", 10));
            vareListe.add(new Item(2, "Hans2", "Narkoman", 5000, "Lang", "Lort", 10));
            vareListe.add(new Item(3, "Hans3", "Narkoman", 5000, "Lang", "Lort", 10));
            vareListe.add(new Item(4, "Hans4", "Narkoman", 5000, "Lang", "Lort", 10));
        }
        return "index";
    }

    @GetMapping("/Vare")
    public String Vare (Model model) {
        model.addAttribute("vare", vareListe);
        return "vare";
    }

    @GetMapping("/createItem")
    public String createItem(Model model){
        model.addAttribute("item", new Item());
        return "createItem";
    }

    @PostMapping("/createItem")
    public String createItem(@ModelAttribute Item vare) {
        vare.setId(vareListe.size()+1);
        vareListe.add(vare);
        return "redirect:/Item";
    }

    @GetMapping("/editItem")
    public String editItem(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        model.addAttribute("item", vareListe.get(id-1));
        return "editItem";
    }
    @PostMapping("/editItem")
    public String editItem(@ModelAttribute Item vare){
        vareListe.set(vare.getId()-1, vare);
        return "redirect:/Item";
    }

}