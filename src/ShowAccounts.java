public class ShowAccounts {
    private CreateAccount account;

    public ShowAccounts(CreateAccount account) {
        this.account = account;
    }
    public void showAccount() {
        System.out.println("Name of account holder: " + account.getName());
        System.out.println("Account no.: " + account.getAccno());
        System.out.println("Account type: " + account.getAcc_type());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Account created at "+ account.getCurrentDate());
    }
}
