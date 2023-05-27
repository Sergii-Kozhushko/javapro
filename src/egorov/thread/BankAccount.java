/**
 * BankAccount.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 27-May-2023 20:28
 */

package egorov.thread;

import java.util.Random;

/*
Создайте класс BankAccount, у которого есть баланс balance.
        Создайте два потока, один из которых пытается снять
        средства со счета, а другой пытается пополнить счет.
        Используйте синхронизированные блоки, чтобы
        гарантировать корректное обновление баланса.
*/
public class BankAccount {
   volatile private double balance;

   public double getBalance() {
      return balance;
   }

   public void setBalance(double balance) {
      this.balance = balance;
   }

   public static void main(String[] args) {
      BankAccount bankAccount = new BankAccount();

      new Thread(new GetMoney(bankAccount)).start();
      new Thread(new PutMoney(bankAccount)).start();

   }
}
class GetMoney implements Runnable{
   BankAccount bankAccount;

   public GetMoney(BankAccount bankAccount) {
      this.bankAccount = bankAccount;
   }

   @Override
   public void run() {
      synchronized (bankAccount) {
         for (int i = 0; i < 10; i++) {
            int operationSum = new Random().nextInt(100) * -1;
            System.out.println("Operation get money: " + operationSum);
            bankAccount.setBalance(bankAccount.getBalance() + operationSum);
            System.out.println("Current balance: " + bankAccount.getBalance());
         }
      }


   }
}
class PutMoney implements Runnable{
   BankAccount bankAccount;

   public PutMoney(BankAccount bankAccount) {
      this.bankAccount = bankAccount;
   }

   @Override
   public void run() {
      synchronized (bankAccount) {
         for (int i = 0; i < 10; i++) {
            int operationSum = new Random().nextInt(100);
            System.out.println("Operation put money: " + operationSum);
            bankAccount.setBalance(bankAccount.getBalance() + operationSum);
            System.out.println("Current balance: " + bankAccount.getBalance());
         }
      }


   }
}