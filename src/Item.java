public class Item {
    private String name;
    private double price;
    private boolean isImported;
    private boolean isExempt;
    private double tax;

    public Item(String name, double price, boolean isImported, boolean isExempt) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempt = isExempt;
        this.tax = TaxCalculator.calculateTax(this);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isExempt() {
        return isExempt;
    }

    public double getTax() {
        return tax;
    }

    public double getPriceWithTax() {
        return this.price + this.tax;
    }
}
