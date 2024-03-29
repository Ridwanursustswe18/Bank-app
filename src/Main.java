import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CreateAccount[] accountsList = null; // Declare BankDetails array

        boolean accountsCreated = false; // Flag to track if accounts have been created
        int n = 0; // Number of customers

        int ch;
        do {
            System.out.println("\n ***Banking System Application***");
            System.out.println("1. Create new account\n2. Display all account details\n3. Search by Account number\n4. Deposit the amount\n5. Withdraw the amount\n6. Update account details\n7. delete account\n8. Exit");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    // Create initial accounts
                    System.out.print("How many number of customers do you want to input? ");
                    n = sc.nextInt();
                    accountsList = new CreateAccount[n]; // Initialize CreateAccount array
                    for (int i = 0; i < accountsList.length; i++) {
                        accountsList[i] = new CreateAccount();
                        accountsList[i].openAccount();
                    }
                    accountsCreated = true; // Set flag to true
                    break;
                case 2:
                    if (!accountsCreated) {
                        System.out.println("Please create an account first.");
                        break;
                    }
                    boolean nullCheck = true;
                    for (CreateAccount account : accountsList) {
                        if (account != null) { // Skip null elements
                            ShowAccounts showAccounts = new ShowAccounts(account);
                            showAccounts.showAccount();
                            nullCheck = false;
                        }
                    }
                    if(nullCheck){
                        System.out.println("Please create an account first.");
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
                    for (CreateAccount account : accountsList) {
                        if (account != null) {
                            SearchAccount searchAccount = new SearchAccount(account);
                            found = searchAccount.search(ac_no);
                        }
                        if (found) {
                            ShowAccounts showAccounts = new ShowAccounts(account);
                            showAccounts.showAccount();
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
                    for (CreateAccount account : accountsList) {
                        if (account != null) {
                            SearchAccount searchAccount = new SearchAccount(account);
                            found = searchAccount.search(ac_no);
                        }
                        if (found) {
                            ShowAccounts showAccounts = new ShowAccounts(account);
                            showAccounts.showAccount();
                            Scanner scanner = new Scanner(System.in);
                            DepositMoney depositMoney = new DepositMoney(account, scanner);
                            depositMoney.deposit();
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
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (CreateAccount account : accountsList) {
                        if (account != null) {
                            SearchAccount searchAccount = new SearchAccount(account);
                            found = searchAccount.search(ac_no);
                        }
                        if (found) {
                            ShowAccounts showAccounts = new ShowAccounts(account);
                            showAccounts.showAccount();
                            Scanner scanner = new Scanner(System.in);
                            WithdrawMoney withdrawMoney = new WithdrawMoney(account, scanner);
                            withdrawMoney.withdrawal(ac_no);
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
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (CreateAccount account : accountsList) {
                        if (account != null) {
                            SearchAccount searchAccount = new SearchAccount(account);
                            found = searchAccount.search(ac_no);
                        }
                        if (found) {
                            ShowAccounts showAccounts = new ShowAccounts(account);
                            showAccounts.showAccount();
                            Scanner scanner = new Scanner(System.in);
                            UpdateAccount updateAccount = new UpdateAccount(account, scanner);
                            updateAccount.updateDetails();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 7:
                    if (!accountsCreated) {
                        System.out.println("Please create an account first.");
                        break;
                    }
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (CreateAccount account : accountsList) {
                        if (account != null) {
                            SearchAccount searchAccount = new SearchAccount(account);
                            found = searchAccount.search(ac_no);
                        }
                        if (found) {
                            DeleteAccount deleteAccount = new DeleteAccount(account);
                            deleteAccount.deleteAccount(accountsList, ac_no);
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 8:
                    System.out.println("See you soon...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (ch != 8);
    }
}
