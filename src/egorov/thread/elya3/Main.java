package egorov.thread.elya3;

import egorov.thread.elya3.BalanceDeposit;
import egorov.thread.elya3.BalanceTransfer;
import egorov.thread.elya3.BalanceWithdraw;

public class Main {


    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        BalanceDeposit balanceDeposit = new BalanceDeposit(bankAccount);
        BalanceWithdraw balanceWithdraw = new BalanceWithdraw(bankAccount);
        BalanceTransfer balanceTransfer = new BalanceTransfer(bankAccount);

        Thread thread1 = new Thread(balanceDeposit);
        Thread thread2 = new Thread(balanceWithdraw);
        Thread thread3 = new Thread(balanceTransfer);
        thread3.start();
        thread1.start();
        thread2.start();


    }
}