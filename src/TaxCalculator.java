public class TaxCalculator {
    private static final double BASIC_SALES_TAX = 0.10;
    private static final double IMPORT_DUTY = 0.05;

    // Calculate the tax based on item properties
    public static double calculateTax(Item item) {
        double tax = 0.0;

        if (!item.isExempt()) {
            tax += roundTax(item.getPrice() * BASIC_SALES_TAX);
        }

        if (item.isImported()) {
            tax += roundTax(item.getPrice() * IMPORT_DUTY);
        }

        return tax;
    }

    // Round up tax to the nearest 0.05
    private static double roundTax(double tax) {
        return Math.ceil(tax * 20.0) / 20.0;
    }
}
