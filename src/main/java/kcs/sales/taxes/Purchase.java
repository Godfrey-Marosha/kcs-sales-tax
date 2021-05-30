/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcs.sales.taxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Godfrey Marosha
 */
 
public class Purchase {
    private List<Item> purchased = new ArrayList<Item>();

    public Item addItem(int quantity, String details, Double price) {
        Item item = new Item(quantity, details, price);
        this.purchased.add(item);
        return item;
    }

    public List<Item> getPurchased(){
        return this.purchased;
    }
}