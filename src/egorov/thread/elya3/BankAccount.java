package egorov.thread.elya3;

import java.util.Random;

public class BankAccount {
    private int depositAccount;
    private int giroAccount;
    final int MINIMUM_SUM_GIRO = 150;
    final int MAXIMUM_SUM_DEPOSIT = 300; //заработали достаточно, работать пока не надо

    public BankAccount() {
    }

    public BankAccount(int depositAccount) {
        this.depositAccount = depositAccount;
    }

    public BankAccount(int depositAccount, int giroAccount) {

        this.depositAccount = depositAccount;
        this.giroAccount = giroAccount;
    }

    // заработали денег
    public void deposit() {

        int sumToDeposit = new Random().nextInt(80);
        //sumToDeposit = new Random().nextInt(80);
        sumToDeposit = 1200;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (this) {
            depositAccount = depositAccount + sumToDeposit;
            System.out.println("Added " + sumToDeposit + " EUR to Deposit: " + getBalanceString());
            notify();
        }
    }

    public synchronized void transferDepositToGiro() {
        //  если у нас мало денег на депозите, то ждем
        if (depositAccount < 150) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        if (depositAccount > 0) {
            giroAccount = giroAccount + depositAccount;
            int depositAccountOld = depositAccount;
            depositAccount = 0;
            System.out.printf("All money %dEUR has been transferred from deposit account to giro account. %s%n",
                    depositAccountOld, getBalanceString());


            notify();
        }
    }

    // тратим деньги со счета Джиро
    public synchronized void withdraw() {
        if (giroAccount < MINIMUM_SUM_GIRO) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        int sumToWithdraw = new Random().nextInt(100);
        if (sumToWithdraw < giroAccount) {
            giroAccount = giroAccount - sumToWithdraw;
            System.out.println("Withdraw: " + sumToWithdraw + "EUR from Giro. " + getBalanceString());
        }

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (giroAccount <= MINIMUM_SUM_GIRO) notify();//Аллё, нада денег
    }

    public synchronized String getBalanceString() {
        return "Giro: " + giroAccount + ", Deposit: " + depositAccount;
    }
}