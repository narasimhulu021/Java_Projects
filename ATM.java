import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initializing balance and other variables
        double balance = 1000.00; // Initial balance
        boolean exit = false;

        System.out.println("Welcome to the ATM Machine!");
        System.out.println("---------------------------");

        while (!exit) {
            // Display menu
            System.out.println("\nSelect an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Check Balance
                    System.out.printf("Your current balance is: $%.2f%n", balance);
                    break;
                case 2: // Deposit Money
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.printf("You have successfully deposited $%.2f.%n", depositAmount);
                        System.out.printf("Updated balance: $%.2f%n", balance);
                    } else {
                        System.out.println("Invalid amount. Please enter a positive value.");
                    }
                    break;
                case 3: // Withdraw Money
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.printf("You have successfully withdrawn $%.2f.%n", withdrawAmount);
                        System.out.printf("Remaining balance: $%.2f%n", balance);
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient balance. Transaction failed.");
                    } else {
                        System.out.println("Invalid amount. Please enter a positive value.");
                    }
                    break;
                case 4: // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;
                default: // Invalid choice
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}
