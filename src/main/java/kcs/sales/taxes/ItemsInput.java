/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcs.sales.taxes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Godfrey Marosha
 */

public class ItemsInput {
    private Purchase purchase;
    public ItemsInput(String shoppingbasket) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(shoppingbasket));
            String itemDetails;
            this.purchase = new Purchase();
            while ((itemDetails = reader.readLine()) != null) {
                this.purchase.addItem(
                        scanQty(itemDetails),
                        scanDetails(itemDetails),
                        scanShelfPrice(itemDetails)
                );
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public Purchase getPurchase() {
        return this.purchase;
    }

    private int scanQty(String details) {
        Pattern p = Pattern.compile("^[\\d+]+");
        Matcher m = p.matcher(details);
        m.find();
        return Integer.parseInt(m.group(0));
    }

    private String scanDetails(String details) {
        Pattern p = Pattern.compile("(?!^\\d)[A-Za-z].+(?=\\sat\\s\\d+.\\d+$)");
        Matcher m = p.matcher(details);
        m.find();
        return  m.group(0);
    }

    private Double scanShelfPrice(String details) {
        Pattern p = Pattern.compile("\\d+.\\d+$");
        Matcher m = p.matcher(details);
        m.find();
        return Double.parseDouble(m.group(0));
    }
}