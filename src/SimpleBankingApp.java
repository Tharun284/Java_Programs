import java.util.Scanner;

public class SimpleBankingApp {
    static class SavingsAccount {
        double balance;
    
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit Successful. New Balance: $" + balance);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }
    
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal Successful. New Balance: $" + balance);
            } else {
                System.out.println("Invalid withdrawal amount or insufficient funds.");
            }
        }
    
        public double getBalance() {
            return balance;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SavingsAccount sa = new SavingsAccount();

        boolean continueBanking = true;

        while (continueBanking) {
            System.out.println("Welcome to Our Bank!");
            System.out.println("Choose Account Type:");
            System.out.println("1. Savings Account");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                // Prompt user to deposit initial amount
                System.out.print("Enter initial deposit amount: ");
                double initialDeposit = sc.nextDouble();
                sa.deposit(initialDeposit);

                // Perform transactions
                boolean continueTransactions = true;
                while (continueTransactions) {
                    System.out.println("\nChoose an Option:");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Exit");
                    System.out.print("Enter your choice: ");
                    int option = sc.nextInt();

                    switch (option) {
                        case 1:
                            System.out.print("Enter deposit amount: ");
                            double depositAmount = sc.nextDouble();
                            sa.deposit(depositAmount);
                            break;
                        case 2:
                            System.out.print("Enter withdrawal amount: ");
                            double withdrawAmount = sc.nextDouble();
                            sa.withdraw(withdrawAmount);
                            break;
                        case 3:
                            System.out.println("Your Balance: $" + sa.getBalance());
                            break;
                        case 4:
                            System.out.println("Thank you for banking with us!");
                            continueTransactions = false;
                            continueBanking = false;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }
            } else if (choice == 2) {
                System.out.println("Thank you for banking with us!");
                continueBanking = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
