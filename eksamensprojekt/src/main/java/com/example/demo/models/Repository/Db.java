package com.example.demo.models.Repository;

import com.example.demo.models.Employee;
import com.example.demo.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//Alle 4 har været indenover denne klasse
@Repository
public class Db {

    @Autowired
    private JdbcTemplate jdbc;

    //Sebastian Duedahl
    //Vælger et specifik item fra vores database ud fra et givent id og laver det til et objekt.
    //Objektet bliver til sidst returneret.
    public Item get(int id){
        String sql = "SELECT * FROM Item WHERE itemId = " + id;

        SqlRowSet rs = jdbc.queryForRowSet(sql);
        rs.next();

        Item item = new Item(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4) +
                            rs.getString(5), rs.getString(6), rs.getInt(7));

        return item;

    }

    //Mikkel Olsen
    //Hiver alle items op fra databasen. Hvert item bliver lavet til et objekt
    //og gemt i en arraylist og den arraylist bliver derefter returneret.
    public List<Item> getItems(){

        List<Item> itemList = new ArrayList<>();

        String query = "SELECT * FROM Item;";

        SqlRowSet rs = jdbc.queryForRowSet(query);
            while (rs.next()) {
                itemList.add(new Item(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getInt(7)));
            }

        return itemList;

    }

    //Tino Andreasen
    //Nedenstående metode hiver alle ikke-glas items op fra items ud fra et angivet dimensionSize.
    public List<Item> getMaterialList(String dimensionSize){

        List<Item> materialList = new ArrayList<>();

        String query = "SELECT * FROM Item WHERE itemDimensions = '" + dimensionSize +"' AND NOT itemType = 'Glas';";

        SqlRowSet rs = jdbc.queryForRowSet(query);
        while (rs.next()) {
            materialList.add(new Item(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getInt(7)));
        }

        return materialList;
    }


    //Micki Høeg
    //Nedenstående metode tager et item object som parameter og sender dataen ned i vores database.
    public void create (Item i){


            String sql = "INSERT INTO Item(itemName, itemPrice, itemDescription, itemDimensions, " +
                    "itemType, itemQuantity)" + "VALUES" +
                    "('" + i.getName() + "', " +
                    i.getPrice() + ", '" +
                    i.getDescription() + "', '" +
                    i.getDimensions() + "', '" +
                    i.getType() + "', " +
                    i.getQuantity() + ")";

            jdbc.update(sql);
    }

    //Sebastian Duedahl
    //Redigerer en enkelt vare og opdatere det i vores database.
    public void editItem(Item i){


            String sql = "UPDATE Item" +
                    " SET itemName = '" + i.getName() +
                    "', itemPrice = " + i.getPrice() +
                    ", itemDescription = '" + i.getDescription() +
                    "', itemDimensions = '" + i.getDimensions() +
                    "', itemType = '" + i.getType() +
                    "', itemQuantity = " + i.getQuantity() + " " +
                    "WHERE itemId = " + i.getId() + ";";

            jdbc.update(sql);

        }

    //Mikkel Olsen
    //Identisk med vore getItems metode. I det her tilfælde er det så bare employees den henter (uden deres password og
    // username da denne metode kun skal bruges til at kunne se en liste over de ansatte hos Interglas).
    public List<Employee> getEmployees(){

        List<Employee> employeeList = new ArrayList<>();

        String query = "SELECT employeeId, employeeName, employeeMail, employeePhonenumber FROM Employee;";

        SqlRowSet rs = jdbc.queryForRowSet(query);

        while(rs.next()){
            employeeList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }

        return employeeList;
     }
}
