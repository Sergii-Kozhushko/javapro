package egorov.thread.elya3;

public class BalanceDeposit implements Runnable{

        private BankAccount bankAccount;

        public BalanceDeposit(BankAccount bankAccount) {
            this.bankAccount = bankAccount;
        }

        @Override
        public void run() {
            while (true){
               // int amount = (int) (Math.random() * 20) + 1;
                bankAccount.deposit();
            }
        }
    }