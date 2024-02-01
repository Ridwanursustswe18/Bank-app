import java.util.Scanner;

public class WithdrawMoney {
    private CreateAccount account;
    private Scanner sc;
public WithdrawMoney(CreateAccount account,Scanner sc){
    this.account = account;
    this.sc =sc;

}

    public void withdrawal(String ac_no) {
        double balance = account.getBalance();
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();

            String acc_type = account.getAcc_type();
            boolean allowed = true;
            assert acc_type != null;
        if (acc_type.equalsIgnoreCase("saving")) {
            if (balance - amt < 500) {
                allowed = false;
                System.out.println("Insufficient balance for saving account (minimum balance: 500)");
            }
        } else if (acc_type.equalsIgnoreCase("current")) {
            if (balance - amt < 1000) {
                allowed = false;
                System.out.println("Insufficient balance for current account (minimum balance: 1000)");
            }
        } else if (acc_type.equalsIgnoreCase("salary")) {
            if (balance - amt < 1500) {
                allowed = false;
                System.out.println("Insufficient balance for salary account (minimum balance: 1500)");
            }
        }


        if (allowed) {
            account.setBalance(balance-amt);
            System.out.println("Balance after withdrawal: " + account.getBalance());
        }




    }

}
