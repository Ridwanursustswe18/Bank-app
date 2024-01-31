import java.time.LocalDate;
import java.util.Scanner;

public class BankDetails {
    private String accno;
    private String name;
    private String acc_type;
    private double balance;
    Scanner sc = new Scanner(System.in);
    private LocalDate currentDate;
    public BankDetails() {
        this.currentDate = LocalDate.now(); // Initialize currentDate in the constructor
    }
    public void openAccount() {



        System.out.print("Enter Account No: ");
        accno = sc.next();
        System.out.print("Enter Account type: ");
        acc_type = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        boolean validBalance = false;
        while (!validBalance) {
            System.out.print("Enter Balance (initial balance should be greater than or equal to 500 ): ");
            balance = sc.nextDouble();
            if (balance >= 500) {
                validBalance = true;
            } else {
                System.out.println("Initial balance should be greater than or equal to 500. Please enter a valid amount.");
            }
        }

    }
    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accno);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
        System.out.println("Account created at "+ currentDate);
    }
    //method to deposit money  
    public void deposit() {
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        balance = balance + amt;
    }
    //method to withdraw money  
    public void withdrawal() {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );
        }
    }
    //method to search an account number  
    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            showAccount();
            return (true);
        }
        return (false);
    }
    public static void updateDetails(BankDetails[] accounts, String ac_no, Scanner sc) {
        for (BankDetails account : accounts) {
            if (account.accno.equals(ac_no)) {
                System.out.println("Enter the type of account you want to change to");
                account.acc_type = sc.next();
                System.out.println("Account details updated successfully.");
                return; // Exit loop if account found and updated
            }
        }
        // Print message if account not found
        System.out.println("Account with account number " + ac_no + " not found.");
    }

}
