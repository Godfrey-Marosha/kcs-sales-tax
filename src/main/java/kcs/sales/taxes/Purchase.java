import java.util.ArrayList;
import java.util.List;

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