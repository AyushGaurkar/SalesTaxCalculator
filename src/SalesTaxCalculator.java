import java.util.Scanner;

public class SalesTaxCalculator {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Receipt receipt = new Receipt();

        System.out.println("Enter items in format '1 item_name at price'. Type 'done' to finish:");

        while (true) {
            String input = inputHandler.getInput();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                Item item = ItemFactory.createItemFromInput(input);
                receipt.addItem(item);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("\nReceipt:");
        for (String line : receipt.generateReceipt()) {
            System.out.println(line);
        }
    }
}
