/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcs.sales.taxes;

import java.util.List;

/**
 *
 * @author Godfrey Marosha
 */
 
public class TaxTotalCalc {
    private Double taxTotal = 0.00;
    private Double saleTotal = 0.00;
    private Double itemTotal = 0.00;

    public TaxTotalCalc(List<Item> items){
        for(Item item: items){
            this.itemTotal = this.itemTotal + (item.getPrice() * item.getQty());
            this.taxTotal = this.taxTotal + computeSalesTax(item);
        }
        this.saleTotal = this.itemTotal + this.taxTotal;
    }

    private Double computeSalesTax(Item item){
        Double tax = .10;
        if (item.isExempt()){
            tax = .00;
        }

        if (item.isImport()){
            tax = tax + .05;
        }
        Double rounded = roundAmount((item.getPrice()*tax) * item.getQty());
        item.setAfterTax(rounded + (item.getPrice() * item.getQty()));
        return rounded;
    }

    public Double getTaxTotal() {
        return this.taxTotal;
    }

    public Double getSaleTotal() {
        return this.saleTotal;
    }

    private Double roundAmount(Double amount){
        return Math.ceil((amount * 20.0)) / 20.0;
    }

    private Double computeSaleTotal(){
        return this.saleTotal = (this.taxTotal + this.itemTotal);
    }
}