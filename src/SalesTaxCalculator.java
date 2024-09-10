public class SalesTaxCalculator {
    public static void main(String[] args) {
        Receipt receipt = new Receipt();

        // Sample Input 1
        receipt.addItem(new Item("book", 12.49, false, true));
        receipt.addItem(new Item("music CD", 14.99, false, false));
        receipt.addItem(new Item("chocolate bar", 0.85, false, true));

        System.out.println("Output for Input 1:");
        receipt.printReceipt();

        // Sample Input 2
        receipt = new Receipt();
        receipt.addItem(new Item("imported box of chocolates", 10.00, true, true));
        receipt.addItem(new Item("imported bottle of perfume", 47.50, true, false));

        System.out.println("\nOutput for Input 2:");
        receipt.printReceipt();

        // Sample Input 3
        receipt = new Receipt();
        receipt.addItem(new Item("imported bottle of perfume", 27.99, true, false));
        receipt.addItem(new Item("bottle of perfume", 18.99, false, false));
        receipt.addItem(new Item("packet of headache pills", 9.75, false, true));
        receipt.addItem(new Item("box of imported chocolates", 11.25, true, true));

        System.out.println("\nOutput for Input 3:");
        receipt.printReceipt();
    }
}
