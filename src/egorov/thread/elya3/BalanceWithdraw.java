package egorov.thread.elya3;

public class BalanceWithdraw implements Runnable {
    private BankAccount bankAccount;

    public BalanceWithdraw(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        while (true){

            bankAccount.withdraw();
        }
    }
}