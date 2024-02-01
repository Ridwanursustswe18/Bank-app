import java.util.Scanner;

public class UpdateAccount {
    private final Scanner sc;
    private CreateAccount account;
    public UpdateAccount(CreateAccount account, Scanner sc){
        this.account = account;
        this.sc = sc;
    }
    public  void updateDetails() {
        System.out.println("Enter the type of account you want to change to");
        String acc_type = sc.next();
        if(acc_type.equalsIgnoreCase("current") && account.getBalance()<1000){
            System.out.println("Not enough balance to update to "+acc_type);
        }else if(acc_type.equalsIgnoreCase("salary") && account.getBalance()<1500){
            System.out.println("Not enough balance to update to "+acc_type);
        }else {
            account.setAcc_type(acc_type);

        }
        }
}
