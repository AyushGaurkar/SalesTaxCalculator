import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Item> items;
    private double totalSalesTax;
    private double totalPrice;

    public Receipt() {
        this.items = new ArrayList<>();
        this.totalSalesTax = 0.0;
        this.totalPrice = 0.0;
    }

    public void addItem(Item item) {
        items.add(item);
        totalSalesTax += item.getTax();
        totalPrice += item.getPriceWithTax();
    }

    public List<String> generateReceipt() {
        List<String> receiptLines = new ArrayList<>();

        for (Item item : items) {
            receiptLines.add(item.getName() + ": " + String.format("%.2f", item.getPriceWithTax()));
        }
        receiptLines.add("Sales Taxes: " + String.format("%.2f", totalSalesTax));
        receiptLines.add("Total: " + String.format("%.2f", totalPrice));

        return receiptLines;
    }
}
