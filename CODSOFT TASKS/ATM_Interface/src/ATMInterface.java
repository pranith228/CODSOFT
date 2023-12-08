import java.util.Scanner;

// Simple ATM User Interface
public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize a bank account with an initial balance of $1000
        BankAccount userAccount = new BankAccount(1000);

        // Initialize the ATM with the user's bank account
        ATM atm = new ATM(userAccount);

        int choice;
        double amount;

        do {
            // Display options to the user
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: Rs.");
                    amount = scanner.nextDouble();
                    atm.withdraw(amount);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: Rs.");
                    amount = scanner.nextDouble();
                    atm.deposit(amount);
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Exiting. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
