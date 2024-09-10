package org.example;

//Create a record 'Client' with the properties First Name, Last Name, and Customer Number (choose suitable English field names).
//Create a class 'Account' (not a record, should initially be mutable) with the properties Account Number (String),
// Account Balance (BigDecimal), and the associated customer.
//Implement a method to deposit money into the account.
//Implement a method to withdraw money from the account
//Create a class 'BankService' that manages a set of accounts.
//Implement a method in BankService to open an account. It should only require a customer as an argument and should return the new account number.
//Implement a method in BankService to transfer a specific amount (as BigDecimal) from one account number (as String) to another account number (as String).

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Client john = new Client(100,"John","Johnson");
        Client david = new Client(101,"David","Davidson");
        System.out.println(john);
        System.out.println();

        BankService bankService = new BankService();
        bankService.openAccount(john);
        bankService.openAccount(david);
        System.out.println(bankService);

        bankService.openAccount(john);
        System.out.println(bankService);
        System.out.println();

        bankService.getAccount("1002").deposit(new BigDecimal("500.0"));
        System.out.println(bankService);

        bankService.transfer("1002","1001", new BigDecimal("100.0"));
        System.out.println(bankService);

        bankService.transfer("1002","1061", new BigDecimal("200.0"));
        System.out.println(bankService);
    }
}