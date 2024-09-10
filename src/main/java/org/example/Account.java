package org.example;

import java.math.BigDecimal;

public class Account {
    private String number;
    private BigDecimal balance;
    private Client client;

    public Account(String number, BigDecimal balance, Client client) {
        this.number = number;
        this.balance = balance;
        this.client = client;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    public int getClientId() {
        return this.client.id();
    }

    public String getNumber() {
        return this.number;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "Account: " +
                "number='" + number + '\'' +
                " balance=" + balance +
                " client=" + client +
                "; ";
    }
}
