package com.example.demo.models.Repository;

import com.example.demo.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Db {

    @Autowired
    private JdbcTemplate jdbc;

    public Db(){}

    //Vælger et specifik item fra vores db
    public Item get(int id){
        String sql = "SELECT * FROM Item WHERE itemId = " + id;

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        rs.next();

        Item item = new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4) +
                            rs.getString(5), rs.getString(6), rs.getInt(7));

        return item;

    }

    //hiver alle items op fra vores db og smider dem i en liste
    public List<Item> getItems(){

        List<Item> items = new ArrayList<>();

        String sql = "SELECT * FROM Item";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while(rs.next()){

            items.add(new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4) +
                    rs.getString(5), rs.getString(6), rs.getInt(7)));
        }

        return items;
    }

    //laver et item og smider det i vores db.
    public void create (Item i){

        String sql = "insert into Item(itemName, itemDescription, itemPrice, itemDimensions, " +
                      "itemType, itemQuantity)" + "values" +
                      "('" + i.getName() + "', '" +
                             i.getDescription() + "', " +
                             i.getPrice() + ", '" +
                             i.getDimensions() + "', '" +
                             i.getType() + "', " +
                             i.getQuantity() + ")";

        int rowsAffected = jdbc.update(sql);
        System.out.println("Rows affected: " + rowsAffected);
    }
}
