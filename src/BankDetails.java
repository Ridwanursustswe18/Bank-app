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
            System.out.println("Enter Balance (initial balance should be greater than or equal to 500 for saving accounts, 1000 for current accounts, and 1500 for salary accounts): ");
            balance = sc.nextDouble();
            String accTypeLower = acc_type.toLowerCase(); // Convert account type to lowercase
            if (accTypeLower.equals("saving") && balance >= 500) {
                validBalance = true;
            } else if (accTypeLower.equals("current") && balance >= 1000) {
                validBalance = true;
            } else if (accTypeLower.equals("salary") && balance >= 1500) {
                validBalance = true;
            } else {
                System.out.println("Enter Balance (initial balance should be greater than or equal to 500 for saving accounts, 1000 for current accounts, and 1500 for salary accounts): ");
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
    public void withdrawal(BankDetails[] accounts,String ac_no) {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        String account_type=null;
        for (BankDetails account : accounts) {
            if (account.accno.equals(ac_no)) {
                account_type = account.acc_type;
                break;
            }
        }
            boolean allowed = true;
            assert account_type != null;
        if (account_type.equalsIgnoreCase("saving")) {
            if (balance - amt < 500) {
                allowed = false;
                System.out.println("Insufficient balance for saving account (minimum balance: 500)");
            }
        } else if (account_type.equalsIgnoreCase("current")) {
            if (balance - amt < 1000) {
                allowed = false;
                System.out.println("Insufficient balance for current account (minimum balance: 1000)");
            }
        } else if (account_type.equalsIgnoreCase("salary")) {
            if (balance - amt < 1500) {
                allowed = false;
                System.out.println("Insufficient balance for salary account (minimum balance: 1500)");
            }
        }


        if (allowed) {
            balance -= amt;
            System.out.println("Balance after withdrawal: " + balance);
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
    public static void deleteAccount(BankDetails[] accounts, String accNo) {
        System.out.println("Are you sure you want to delete this account "+accNo);
        int index = -1;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].search(accNo)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            // Shift elements after the deleted account to the left
            for (int i = index; i < accounts.length - 1; i++) {
                accounts[i] = accounts[i + 1];
            }
            // Set the last element to null
            accounts[accounts.length - 1] = null;
            System.out.println("Account with account number " + accNo + " has been deleted.");
        } else {
            System.out.println("Account with account number " + accNo + " does not exist.");
        }
    }

}
