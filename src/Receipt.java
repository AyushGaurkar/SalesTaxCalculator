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
        double itemTax = TaxCalculator.calculateTax(item);
        double finalPrice = item.getPrice() + itemTax;

        items.add(item);
        totalSalesTax += itemTax;
        totalPrice += finalPrice;
    }

    public void printReceipt() {
        for (Item item : items) {
            double itemTax = TaxCalculator.calculateTax(item);
            double finalPrice = item.getPrice() + itemTax;
            System.out.println(item.getName() + ": " + String.format("%.2f", finalPrice));
        }
        System.out.println("Sales Taxes: " + String.format("%.2f", totalSalesTax));
        System.out.println("Total: " + String.format("%.2f", totalPrice));
    }
}
