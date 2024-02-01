import java.util.Scanner;

public class DepositMoney {
    public CreateAccount account;
    private Scanner sc;

    public DepositMoney(CreateAccount account, Scanner scanner) {
        this.account = account;
        this.sc = scanner;
    }
        public void deposit() {
            System.out.println("Enter the amount you want to deposit: ");
            long amt = sc.nextLong();
            double balance = account.getBalance();
            account.setBalance(balance+amt);
    }
}
