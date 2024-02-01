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
        String prevAccType = account.getAcc_type();
        account.setAcc_type(acc_type);
        System.out.println("Your account has been changed from "+prevAccType+" to "+acc_type);
    }
}
