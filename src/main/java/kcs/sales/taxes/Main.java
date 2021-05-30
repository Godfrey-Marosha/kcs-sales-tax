/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcs.sales.taxes;

/**
 *
 * @author Godfrey Marosha
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] defaultShoppingBaskets = {
                "shopping-baskets/input1.txt",
                "shopping-baskets/input2.txt",
                "shopping-baskets/input3.txt"
        };

        String[] queuedShoppingBasketFiles = (defaultShoppingBaskets.length > 0) ?defaultShoppingBaskets : defaultShoppingBaskets;

        for (String shoppingbasket : queuedShoppingBasketFiles) {
            ItemsInput rScanner = new ItemsInput(shoppingbasket);
            Purchase purchase = rScanner.getPurchase();
            TaxTotalCalc calculate = new TaxTotalCalc(purchase.getPurchased());
            ItemsReceipt display = new ItemsReceipt();
            for(Item item: purchase.getPurchased()){
                display.purchaseList(item);
            }
            display.salesTax(calculate.getTaxTotal());
            display.totalSale(calculate.getSaleTotal());
      }
  }
}