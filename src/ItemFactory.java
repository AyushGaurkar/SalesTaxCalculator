public class ItemFactory {

    public static Item createItemFromInput(String input) {
        String[] parts = input.split(" at ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid format. Please use 'quantity item_name at price'.");
        }

        String nameAndQuantity = parts[0]; // e.g. "1 book"
        double price = Double.parseDouble(parts[1]);

        String[] nameParts = nameAndQuantity.split(" ", 2); // ["1", "book"]
        if (nameParts.length != 2) {
            throw new IllegalArgumentException("Invalid item format.");
        }

        int quantity = Integer.parseInt(nameParts[0]); // Parse the quantity
        String name = nameParts[1];

        // Determine if the item is imported or exempt based on name
        boolean isImported = name.contains("imported");
        boolean isExempt = name.contains("book") || name.contains("chocolate") || name.contains("pills");

        // Handle multiple quantities by creating the item and multiplying price and quantity
        return new Item(name, price, quantity, isImported, isExempt);
    }
}
