public class SearchAccount {
    private CreateAccount account;

    public SearchAccount(CreateAccount account) {
        this.account = account;
    }
        public boolean search(String ac_no) {
        if(account.getAccno()!=null) {
            return account.getAccno().equals(ac_no);
        }
        return (false);
    }
}
