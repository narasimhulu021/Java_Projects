package Hospital_Project;

import java.util.*;

class User {
    String username;
    String password;
    List<Order> orderHistory = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Restaurant {
    String name;
    Map<String, Double> menu = new LinkedHashMap<>();

    public Restaurant(String name) {
        this.name = name;
    }

    public void addMenuItem(String item, double price) {
        menu.put(item, price);
    }

    @Override
    public String toString() {
        return name + " (Menu: " + menu + ")";
    }
}

class Order {
    String restaurantName;
    Map<String, Integer> items = new LinkedHashMap<>();
    double totalPrice;

    public Order(String restaurantName, Map<String, Integer> items, double totalPrice) {
        this.restaurantName = restaurantName;
        this.items.putAll(items);
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Restaurant: " + restaurantName + ", Items: " + items + ", Total Price: $" + totalPrice;
    }
}

public class OnlineFoodDeliverySystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<User> users = new ArrayList<>();
    private static final List<Restaurant> restaurants = new ArrayList<>();
    private static User loggedInUser = null;

    public static void main(String[] args) {
        // Adding some dummy restaurants and users
        initializeDummyData();

        while (true) {
            System.out.println("\n--- Online Food Delivery System ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 : registerUser();
                case 2 : loginUser();
                case 3 : {
                    System.out.println("Exiting system. Goodbye!");
                    return;
                }
                default : System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeDummyData() {
        Restaurant rest1 = new Restaurant("Pizza Palace");
        rest1.addMenuItem("Pepperoni Pizza", 10.99);
        rest1.addMenuItem("Margherita Pizza", 8.99);

        Restaurant rest2 = new Restaurant("Burger Barn");
        rest2.addMenuItem("Cheeseburger", 6.49);
        rest2.addMenuItem("Veggie Burger", 5.99);

        restaurants.add(rest1);
        restaurants.add(rest2);

        users.add(new User("admin", "admin123")); // Admin user
    }

    private static void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        users.add(new User(username, password));
        System.out.println("Registration successful!");
    }

    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                loggedInUser = user;
                System.out.println("Login successful!");
                userMenu();
                return;
            }
        }
        System.out.println("Invalid credentials. Please try again.");
    }

    private static void userMenu() {
        while (true) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. View Restaurants");
            System.out.println("2. Place Order");
            System.out.println("3. View Order History");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 : viewRestaurants();
                case 2 : placeOrder();
                case 3 : viewOrderHistory();
                case 4 : {
                    loggedInUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                }
                default : System.out.println("Invalid choice.");
            }
        }
    }

    private static void viewRestaurants() {
        System.out.println("\n--- Restaurants ---");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ". " + restaurants.get(i));
        }
    }

    private static void placeOrder() {
        System.out.println("\n--- Place Order ---");
        viewRestaurants();
        System.out.print("Select a restaurant by number: ");
        int restIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (restIndex < 0 || restIndex >= restaurants.size()) {
            System.out.println("Invalid restaurant selection.");
            return;
        }

        Restaurant selectedRestaurant = restaurants.get(restIndex);
        Map<String, Integer> cart = new LinkedHashMap<>();
        double total = 0.0;

        while (true) {
            System.out.println("Menu: " + selectedRestaurant.menu);
            System.out.print("Enter item name to add to cart (or type 'done' to finish): ");
            String item = scanner.nextLine();
            if (item.equalsIgnoreCase("done")) break;

            if (!selectedRestaurant.menu.containsKey(item)) {
                System.out.println("Item not found. Try again.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            cart.put(item, cart.getOrDefault(item, 0) + quantity);
            total += selectedRestaurant.menu.get(item) * quantity;
        }

        System.out.println("Order placed successfully!");
        System.out.printf("Total: $%.2f%n", total);
        loggedInUser.orderHistory.add(new Order(selectedRestaurant.name, cart, total));
    }

    private static void viewOrderHistory() {
        System.out.println("\n--- Order History ---");
        for (Order order : loggedInUser.orderHistory) {
            System.out.println(order);
        }
    }
}

