package com.example.demo.Controllers;

//import com.example.demo.Interfaces.VareRepositoryInterface;
import com.example.demo.models.Item;
import com.example.demo.models.Repository.Db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        model.addAttribute("item", database.getItems("SELECT * FROM Item;"));

        return "item";
    }

    @RequestMapping(value = "/createItem", method = RequestMethod.GET)
    public String createItem(Model model)
    {
        model.addAttribute("item", new Item());

        return "createItem";
    }

    @RequestMapping(value = "/createItem", method = RequestMethod.POST)
    public String createItem(@ModelAttribute Item item)
    {
        database.create(item);

        return "redirect:/item";
    }

    @GetMapping("/editItem")
    public String editItem(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {

        model.addAttribute("item", database.getItems("SELECT * FROM Item;").get(id-1));

        return "editItem";
    }

    @PostMapping("/editItem")
    public String editItem(@ModelAttribute Item item){

        database.editItem(item);

        return "redirect:/item";
    }

    @GetMapping("/materialList")
    public String materialList(@RequestParam(value= "id", defaultValue = "1") int id, Model model) {
        if(id == 1) {
            model.addAttribute("item", database.getItems("SELECT * FROM Item WHERE itemDimensions = '0-700' AND NOT itemType = 'Glas';"));
        } else if (id == 2) {
            model.addAttribute("item", database.getItems("SELECT * FROM Item WHERE itemDimensions = '701-900' AND NOT itemType = 'Glas';"));
        } else {
            model.addAttribute("item", database.getItems("SELECT * FROM Item WHERE itemDimensions = '901+' AND NOT itemType = 'Glas';"));
        }
      
        return "materialList";
    }

    @GetMapping("/employeeList")
    public String Employee (Model model) {

        model.addAttribute("employee", database.getEmployees("SELECT * FROM Employee;"));
        System.out.println(database.getEmployees("SELECT * FROM Employee;"));

        return "employee";

    }



}