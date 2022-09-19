package com.banking.projectha;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Banking Application...");
        BankAccount bankAccount = new BankAccount("Harsh Chougule", "A10012");
        bankAccount.showMenu();
        bankAccount.customerList();
    }
}