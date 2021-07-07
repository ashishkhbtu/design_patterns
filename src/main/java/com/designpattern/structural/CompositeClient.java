package com.designpattern.structural;

import java.util.ArrayList;
import java.util.List;

//Component
interface Account{
    int getBalance();
}

//Leaf
class SavingAccount implements Account{

    String accountNumber;
    int balance;

    public SavingAccount(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}

//Leaf
class CurrentAccount implements Account{
    String accountNumber;
    int balance;

    public CurrentAccount(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}

//Composite
class CompositeAccount implements Account{

    List<Account> accountList = new ArrayList<>();

    public void addAccount(Account account){
        accountList.add(account);
    }

    @Override
    public int getBalance() {
        int total = 0;
        for(Account a: accountList){
            total += a.getBalance();
        }
        return total;
    }
}

// Client
public class CompositeClient {
    public static void main(String[] args) {
        CompositeAccount compositeAccount = new CompositeAccount();
        compositeAccount.addAccount(new SavingAccount("S001", 100));
        compositeAccount.addAccount(new CurrentAccount("C001", 200));
        System.out.println(compositeAccount.getBalance());
    }
}
