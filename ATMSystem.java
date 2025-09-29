import java.util.Scanner;

// Step 4: BankAccount class
class BankAccount 
{
    private double balance;

    public BankAccount(double initialBalance) 
    {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Deposit successful.");
        } else {
            System.out.println(" Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(" Withdrawal successful.");
        } else if (amount > balance) {
            System.out.println(" Insufficient balance.");
        } else {
            System.out.println(" Invalid withdrawal amount.");
        }
    }
}

// Step 1 & 3: ATM class
class ATM 
{
    private BankAccount account;

    public ATM(BankAccount account) 
    {
        this.account = account;
    }

    public void start() 
    {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Step 2: User Interface
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public void checkBalance() {
        System.out.printf("💰 Current Balance: ₹%.2f\n", account.getBalance());
    }
}

// Step 5, 6, 7: Main class to connect everything
public class ATMSystem {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}