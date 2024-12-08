import java.util.Scanner;

public class SimpleBankingSystem {

    // Attributes to store account information
    private String accountHolderName;
    private int accountNumber;
    private double accountBalance;

    // Constructor to initialize account details
    public SimpleBankingSystem(String name, int number, double balance) {
        this.accountHolderName = name;
        this.accountNumber = number;
        this.accountBalance = balance;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("\nAccount Details:");
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: Rs." + accountBalance);
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("\nRs." + amount + " deposited successfully!");
        } else {
            System.out.println("\nInvalid deposit amount!");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("\nRs." + amount + " withdrawn successfully!");
        } else {
            System.out.println("\nInvalid withdrawal amount or insufficient balance!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for account creation
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Account Number: ");
        int number = scanner.nextInt();

        System.out.print("Enter Initial Balance: Rs.");
        double balance = scanner.nextDouble();

        // Create an account
        SimpleBankingSystem account = new SimpleBankingSystem(name, number, balance);

        int choice;
        do {
            // Display menu options
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Display Account Details");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            // Perform operations based on user choice
            switch (choice) {
                case 1:
                    account.displayAccountDetails();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: Rs.");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: Rs.");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you for using our banking system!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
