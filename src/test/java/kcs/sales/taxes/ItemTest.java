/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kcs.sales.taxes;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
/**
 *
 * @author Godfrey Marosha
 */
@RunWith(Parameterized.class)
public class ItemTest {

    private static Item createItem(String details, Double price, int qty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Boolean isImport = false;
    private Boolean isExempt = false;
    private int qty;
    private String details;
    private Double price;
    private Double afterTax;

	public ItemTest(int qty, String details, Double price){
        this.qty = qty;
        this.details = details;
        this.price = price;
        setSaleType(details);
	}
        
        private void setSaleType(String details){
        Pattern exemptPattern = Pattern.compile("pills|chocolate|book|wine");
        Pattern importPattern = Pattern.compile("imported");
        if (exemptPattern.matcher(details).find()) {
            this.isExempt = true;
        }

        if (importPattern.matcher(details).find()) {
            this.isImport = true;
        }
    }

	@Parameterized.Parameters
	 public static Collection<Object[]> data() {
        Object[][] Item;
	   return Arrays.asList();
	 }

	 @Test
	 public void testItemPriceWithTax(){
		Item item = ItemTest.createItem(details, price, qty);
		Assert.assertEquals("test failed for price with tax"+item.getDetails(), afterTax ,item.getAfterTax(), 0.0f );
	 }
}