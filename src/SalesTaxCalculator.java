import java.util.Scanner;

public class SalesTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Receipt receipt = new Receipt();

        System.out.println("Enter the number of items:");
        int itemCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < itemCount; i++) {
            System.out.println("Enter item details (format: name price imported exempt):");
            String input = scanner.nextLine();
            String[] details = input.split(" ");

            String name = details[0];
            double price = Double.parseDouble(details[1]);
            boolean isImported = details[2].equalsIgnoreCase("yes");
            boolean isExempt = details[3].equalsIgnoreCase("yes");

            Item item = new Item(name, price, isImported, isExempt);
            receipt.addItem(item);
        }

        System.out.println("\nReceipt:");
        receipt.printReceipt();

        scanner.close();
    }
}
