package egorov.thread.elya3;

public class BalanceTransfer implements Runnable {
    private BankAccount bankAccount;
    public BalanceTransfer(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        while (true){
            bankAccount.transferDepositToGiro();
        }
    }
}