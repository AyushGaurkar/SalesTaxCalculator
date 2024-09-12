public class Item {
    private String name;
    private double price;
    private int quantity; // Add quantity field
    private boolean isImported;
    private boolean isExempt;
    private double tax;

    public Item(String name, double price, int quantity, boolean isImported, boolean isExempt) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isImported = isImported;
        this.isExempt = isExempt;
        this.tax = TaxCalculator.calculateTax(this); // Calculate tax for a single item
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price * quantity; // Multiply price by quantity
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempt() {
        return isExempt;
    }

    public double getTax() {
        return tax * quantity; // Multiply tax by quantity
    }

    public double getPriceWithTax() {
        return getPrice() + getTax();
    }
}
