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
        boolean validType = false;
        while (!validType) {
            System.out.println("You can only choose from saving, current, and salary type");
            String accTypeLower = acc_type.toLowerCase(); // Convert account type to lowercase
            if (accTypeLower.equals("saving") || accTypeLower.equals("current") || accTypeLower.equals("salary")) {
                validType = true;
            } else {
                System.out.println("Please enter a valid type of account");
                break;
            }

        }
        if(validType) {
            this.acc_type = acc_type;
            System.out.println("Your accounts type has been changed ");
        }else {
            System.out.println("account update failed");
        }
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
        boolean validType = false;
        while (!validType){
            System.out.println("You can only choose from saving,current and salary type");
            acc_type = sc.next();
            String accTypeLower = acc_type.toLowerCase(); // Convert account type to lowercase
            if (accTypeLower.equals("saving")) {
                validType = true;
            } else if (accTypeLower.equals("current")) {
                validType = true;
            } else if (accTypeLower.equals("salary")) {
                validType = true;
            }else {
                System.out.println("please enter valid type of account");
            }

        }

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
                System.out.println("initial balance should be greater than or equal to 500 for saving accounts, 1000 for current accounts, and 1500 for salary accounts: ");
            }
        }


    }



}
