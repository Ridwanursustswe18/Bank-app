import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankDetails[] C = null; // Declare BankDetails array

        boolean accountsCreated = false; // Flag to track if accounts have been created
        int n = 0; // Number of customers

        int ch;
        do {
            System.out.println("\n ***Banking System Application***");
            System.out.println("1. Create new account\n2. Display all account details\n3. Search by Account number\n4. Deposit the amount\n5. Withdraw the amount\n6. Update account details\n7. Exit");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    // Create initial accounts
                    System.out.print("How many number of customers do you want to input? ");
                    n = sc.nextInt();
                    C = new BankDetails[n]; // Initialize BankDetails array
                    for (int i = 0; i < C.length; i++) {
                        C[i] = new BankDetails();
                        C[i].openAccount();
                    }
                    accountsCreated = true; // Set flag to true
                    break;
                case 2:
                    if (!accountsCreated) {
                        System.out.println("Please create an account first.");
                        break;
                    }
                    for (int i = 0; i < n; i++) {
                        C[i].showAccount();
                    }
                    break;
                case 3:
                    if (!accountsCreated) {
                        System.out.println("Please create an account first.");
                        break;
                    }
                    System.out.print("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 4:
                    if (!accountsCreated) {
                        System.out.println("Please create an account first.");
                        break;
                    }
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 5:
                    if (!accountsCreated) {
                        System.out.println("Please create an account first.");
                        break;
                    }
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 6:
                    if (!accountsCreated) {
                        System.out.println("Please create an account first.");
                        break;
                    }
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();

                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_no);
                        if (found) {
                            C[i].updateDetails(C,ac_no,sc);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 7:
                    System.out.println("See you soon...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (ch != 7);
    }
}
