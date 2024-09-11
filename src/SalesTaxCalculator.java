import java.util.Scanner;

public class SalesTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Receipt receipt = new Receipt();

        System.out.println("Enter items in format '1 item_name at price'. Type 'done' to finish:");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }


            String[] parts = input.split(" at ");
            if (parts.length != 2) {
                System.out.println("Invalid format. Please use '1 item_name at price'.");
                continue;
            }

            String nameAndQuantity = parts[0]; // "1 book"
            double price = Double.parseDouble(parts[1]);

            String[] nameParts = nameAndQuantity.split(" ", 2);
            int quantity = Integer.parseInt(nameParts[0]);
            String name = nameParts[1];

            boolean isImported = name.contains("imported");
            boolean isExempt = name.contains("book") || name.contains("chocolate") || name.contains("pills");

            for (int i = 0; i < quantity; i++) {
                Item item = new Item(name, price, isImported, isExempt);
                receipt.addItem(item);
            }
        }

        System.out.println("\nReceipt:");
        for (String line : receipt.generateReceipt()) {
            System.out.println(line);
        }

        scanner.close();
    }
}
