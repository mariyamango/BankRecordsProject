package org.example;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class BankService {
    private Set<Account> accounts;

    public BankService() {
        accounts = new HashSet<>();
    }

    public Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public String openAccount(Client client) {
        int accForClient = 0;
        if (accounts != null) {
            for (Account account : accounts) {
                if (account.getClientId() == client.id()) {
                    accForClient++;
                }
            }
        }
        String newAccountNumber = "" + client.id() + (accForClient + 1);
        Account newAccount = new Account(newAccountNumber, new BigDecimal("0.0"),client);
        accounts.add(newAccount);
        return newAccountNumber;
    }

    @Override
    public String toString() {
        System.out.println("Accounts in Bank Service: ");
        StringBuilder result = new StringBuilder();
        for (Account account : accounts) {
            result.append(account).append("\n");
        }
        return result.toString();
    }

    public void transfer(String from, String to, BigDecimal amount) {
        boolean success1 = false, success2 = false;
        for (Account account : accounts) {
            if (account.getNumber().equals(from) && account.getBalance().compareTo(amount) >= 0) {success1 = true;}
            if (account.getNumber().equals(to)) {success2 = true;}
        }
        if (success1&&success2) {
            for (Account account : accounts) {
                if (account.getNumber().equals(from)) {
                    account.withdraw(amount);
                }
                if (account.getNumber().equals(to)) {
                    account.deposit(amount);
                }
            }
        } else {
            System.out.println("Failed to transfer " + amount + " from " + from + " to " + to);
        }
    }
}
