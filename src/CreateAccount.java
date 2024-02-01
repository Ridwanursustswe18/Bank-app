import java.time.LocalDate;
import java.util.Scanner;

public class CreateAccount {
    public String getAccno() {
        return accno;
    }

    public String getName() {
        return name;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    private String accno;
    private String name;

    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }

    private String acc_type;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;
    Scanner sc = new Scanner(System.in);
    private LocalDate currentDate;
    public CreateAccount() {
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






//    public static void deleteAccount(BankDetails[] accounts, String accNo) {
//        System.out.println("Are you sure you want to delete this account "+accNo);
//        int index = -1;
//        for (int i = 0; i < accounts.length; i++) {
//            if (accounts[i].search(accNo)) {
//                index = i;
//                break;
//            }
//        }
//        if (index != -1) {
//            // Shift elements after the deleted account to the left
//            for (int i = index; i < accounts.length - 1; i++) {
//                accounts[i] = accounts[i + 1];
//            }
//            // Set the last element to null
//            accounts[accounts.length - 1] = null;
//            System.out.println("Account with account number " + accNo + " has been deleted.");
//        } else {
//            System.out.println("Account with account number " + accNo + " does not exist.");
//        }
//    }

}
