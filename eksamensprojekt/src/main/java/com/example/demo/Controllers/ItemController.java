package com.example.demo.Controllers;

import com.example.demo.models.Item;
import com.example.demo.models.Repository.Db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//Alle 4 har været indenover denne klasse
@Controller
public class ItemController {


    @Autowired
    private Db database;

    //Micki Høeg
    @GetMapping("/items")
    public String Item (Model model) {

        model.addAttribute("item", database.getItems());

        return "items";
    }

    //Mikkel Olsen
    @RequestMapping(value = "/createItem", method = RequestMethod.GET)
    public String createItem(Model model)
    {
        model.addAttribute("item", new Item());

        return "createItem";
    }

    //Mikkel Olsen
    @RequestMapping(value = "/createItem", method = RequestMethod.POST)
    public String createItem(@ModelAttribute Item item)
    {
        database.create(item);

        return "redirect:/items";
    }

    //Tino Andreasen
    @GetMapping("/editItem")
    public String editItem(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {

        model.addAttribute("item", database.getItems().get(id-1));

        return "editItem";
    }

    //Tino Andreasen
    @PostMapping("/editItem")
    public String editItem(@ModelAttribute Item item){

        database.editItem(item);

        return "redirect:/items";
    }

    //Mikkel Olsen
    @GetMapping("/materialList")
    public String materialList(@RequestParam int id, Model model) {
        if(id == 1) {
            model.addAttribute("item", database.getMaterialList("0-700"));

        } else if (id == 2) {
            model.addAttribute("item", database.getMaterialList("701-900"));

        } else {
            model.addAttribute("item", database.getMaterialList("901+"));

        }

        return "materialList";
    }

    //Sebastian Duedahl
    @GetMapping("/employeeList")
    public String Employee (Model model) {

        model.addAttribute("employee", database.getEmployees());

        return "employees";

    }
}