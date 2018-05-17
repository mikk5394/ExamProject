package com.example.demo.Controllers;

//import com.example.demo.Interfaces.VareRepositoryInterface;
import com.example.demo.models.Item;
import com.example.demo.models.Repository.Db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {

    //private List<Item> itemList = new ArrayList<>();
    //private ArrayList<Item> reservationsList = new ArrayList<>();


    @Autowired
    private Db database;

    /*
    @GetMapping("/")
        public String index(){
        //Hard-code varer
        // int id, String navn, String beskrivelse, int pris, String mål, String type, int antal
        if(itemList.size() == 0) {
            itemList.add(new Item(1, "Hans1", "Narkoman", 5000, "Lang", "Lort", 10));
            itemList.add(new Item(2, "Hans2", "Narkoman", 5000, "Lang", "Lort", 10));
            itemList.add(new Item(3, "Hans3", "Narkoman", 5000, "Lang", "Lort", 10));
            itemList.add(new Item(4, "Hans4", "Narkoman", 5000, "Lang", "Lort", 10));
        }
        return "index";
    }
    */

    @RequestMapping("item/details")
    public String home(Model model){

        model.addAttribute("item", database.get(1));

        return "item/details";
    }

    @GetMapping("/item")
    public String Item (Model model) {

        model.addAttribute("item", database.getItems());

        return "item";

    }

    @RequestMapping(value = "/createItem", method = RequestMethod.GET)
    public String create(Model model)
    {
        model.addAttribute("item", new Item());

        return "createItem";
    }

    @RequestMapping(value = "/createItem", method = RequestMethod.POST)
    public String create(@ModelAttribute Item item)
    {
        database.create(item);

        return "redirect:/item";
    }

    @GetMapping("/editItem")
    public String editItem(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {

        model.addAttribute("item", database.getItems().get(id-1));

        return "editItem";
    }

    @PostMapping("/editItem")
    public String editItem(@ModelAttribute Item item){

        database.editItem(item);

        return "redirect:/item";
    }

    @GetMapping("/measurements")
    public String glassMeasurements(@ModelAttribute Item item){

        return "measurements";
    }


}