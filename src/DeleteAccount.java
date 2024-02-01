public class DeleteAccount {
    private CreateAccount account;
    public DeleteAccount(CreateAccount account){
        this.account = account;
    }
        public void deleteAccount(CreateAccount[] accounts, String accNo) {
        System.out.println("Are you sure you want to delete this account "+accNo);
        int index = -1;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccno().equals(accNo)) {
                index = i;
                break;
            }
        }

            // Shift elements after the deleted account to the left
            for (int i = index; i < accounts.length - 1; i++) {
                accounts[i] = accounts[i + 1];
            }
            // Set the last element to null
            accounts[accounts.length - 1] = null;
            System.out.println("Account with account number " + accNo + " has been deleted.");

    }
}
