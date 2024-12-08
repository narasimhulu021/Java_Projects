import java.util.ArrayList;
import java.util.Scanner;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class MiniECommerceStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // List of products
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 800.00));
        products.add(new Product("Smartphone", 500.00));
        products.add(new Product("Headphones", 50.00));
        products.add(new Product("Keyboard", 30.00));
        products.add(new Product("Mouse", 20.00));

        // Cart to store selected products
        ArrayList<Product> cart = new ArrayList<>();

        boolean shopping = true;

        System.out.println("Welcome to the Mini E-commerce Store!");
        System.out.println("------------------------------------");

        while (shopping) {
            // Display product list
            System.out.println("\nAvailable Products:");
            for (int i = 0; i < products.size(); i++) {
                System.out.printf("%d. %s - $%.2f%n", i + 1, products.get(i).name, products.get(i).price);
            }
            System.out.println("0. Checkout");

            // User selects a product
            System.out.print("\nEnter the number of the product to add to your cart (0 to checkout): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                // Checkout
                if (cart.isEmpty()) {
                    System.out.println("\nYour cart is empty. Thank you for visiting!");
                } else {
                    double total = 0;
                    System.out.println("\nYour Cart:");
                    for (Product p : cart) {
                        System.out.printf("- %s: $%.2f%n", p.name, p.price);
                        total += p.price;
                    }
                    System.out.printf("Total Amount: $%.2f%n", total);
                    System.out.println("Thank you for shopping with us!");
                }
                shopping = false;
            } else if (choice > 0 && choice <= products.size()) {
                // Add product to cart
                Product selectedProduct = products.get(choice - 1);
                cart.add(selectedProduct);
                System.out.printf("Added '%s' to your cart.%n", selectedProduct.name);
            } else {
                // Invalid choice
                System.out.println("Invalid choice. Please select a valid product number.");
            }
        }

        scanner.close();
    }
}
