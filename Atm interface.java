import java.util.*;

 import java.util.Scanner;

class BankAccount {
    int balance;
    int Transaction;
    String customerName;
    String customerId;
    int flag = 0;

    BankAccount(String cName, String cId) {
        customerName = cName;
        customerId = cId;
    }

    public final void clrscr() {
        try {
            try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } 
    } catch (final Exception es) {
        // System.out.println("nothing here!");
    }

    }

    void checkId() {
        clrscr();
        System.out.println("Welcome " + customerName);
        System.out.println();
        System.out.print("Please enter the Customer ID or PIN: ");
        Scanner id = new Scanner(System.in);
        String chk = id.nextLine();
        if (chk.equals(customerId)) {
            clrscr();
            showMenu();
        } else {
            System.out.println("=================================");
            System.out.println("Wrong Login!!");
            System.out.println("=================================");

            if (flag < 3) {
                flag++;
                checkId();
            }
        }
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            Transaction = amount;
        }
    }

    void withdraw(int amount) {
        if (this.balance > amount) {
            balance = balance - amount;
            Transaction = -amount;
        } else {
            clrscr();
            System.out.println("=================================");
            System.out.println("InSufficient Balance not available for the withdrawl!");
            System.out.println("=================================");
        }
    }

    void getTransaction() {
        if (Transaction > 0) {
            System.out.println("Deposited: " + Transaction);
        } else if (Transaction < 0) {
            System.out.println("Withdraw: " + Math.abs(Transaction));
        } else {
            System.out.println("No Transaction Occured ");
        }
    }

    public void transfer(double amount, BankAccount acc) {
        if (this.balance < amount) {
            clrscr();
            System.out.println("=================================");
            System.out.println("Transfer Fails due to insufficient balance!");
            System.out.println("=================================");
        } else {
            this.balance -= amount;
            acc.balance += amount;
            System.out.println("Account of " + this.customerName + " becomes ₹" + this.balance);
            System.out.println("Account of " + acc.customerName + " becomes ₹" + acc.balance);
            System.out.println("\n");
        }
    }

    private void showMenu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is:  " + customerId);
        do {
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Previous Transaction");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");

            System.out.println("=================================");
            System.out.println("Please Enter the option");
            System.out.println("=================================");
            option = sc.next().charAt(0);
            option = Character.toUpperCase(option);
            System.out.println("\n");

            switch (option) {
                case '1':
                    clrscr();
                    System.out.println("================");
                    System.out.println("Balance " + balance);
                    System.out.println("================");
                    System.out.println("\n");
                    break;

                case '2':
                    clrscr();
                    System.out.println("================");
                    System.out.println("Enter the amount to deposit");
                    System.out.println("================");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                
                case '3':
                    clrscr();
                    System.out.println("================");
                    System.out.println("Enter the amount to withdraw");
                    System.out.println("================");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case '4':
                    clrscr();
                    System.out.println("================");
                    getTransaction();
                    System.out.println("================");
                    System.out.println("\n");
                    break;

                case '5':
                    clrscr();
                    System.out.println("***************");
                    System.out.println("To whom");
                    BankAccount bb = new BankAccount("Vishal", "1002");
                    System.out.println(bb.customerName);
                    System.out.println("***************");
                    System.out.println("Amount to Transfer");
                    double am = sc.nextDouble();
                    System.out.println("***************");
                    transfer(am, bb);
                    break;

                case '6':
                    clrscr();
                    System.out.println("***************");
                    break;
                
                default:
                    clrscr();
                    System.out.println("Invalid Option!!! Please Enter Again");
            }

        } while (option != '6');
        System.out.println("ThankYou For using our services");

    }
}
public class ATMinterface {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount("Raj", "1001");
        ba.checkId();
    }

}