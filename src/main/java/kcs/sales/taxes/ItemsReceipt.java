public class ItemsReceipt {
    private String itemFormat = "%1$-40s %2$6.2f %n";
    private String taxFormat = "%1$40s %2$6.2f %n";
    private String totalFormat = "%1$40s %2$6.2f %n%n%n";

    public void purchaseList(Item item) {
        System.out.format(itemFormat, item.getQty() + " " + item.getDetails() +": ", item.getAfterTax());
    }

    public void salesTax(Double taxTotal) {
        System.out.format(taxFormat, "Sales Taxes:", taxTotal);
    }

    public void totalSale(Double saleTotal) {
        System.out.format(totalFormat, "Total:", saleTotal);
    }
}