package com.banking.projectha;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankAccount {

    String customerName;
    String customerId;
    double balance;
    double previousTransaction;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0 && amount <= balance) {
            balance = balance - amount;
            previousTransaction = - amount;
        } else {
            System.out.println("Invalid amount");
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited : " + previousTransaction);
        } else if (previousTransaction < 0 ) {
            System.out.println("Withdrawn : " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your Id " + customerId);
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("=====================================================================");
            System.out.println("Please select choice ::: ");
            option = sc.next().toUpperCase().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("-------------------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("-------------------------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("-------------------------------------");
                    System.out.println("Enter an amount to deposit : ");
                    System.out.println("-------------------------------------");
                    int amountDep = sc.nextInt();
                    deposit(amountDep);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("-------------------------------------");
                    System.out.println("Enter an amount to withdraw : ");
                    System.out.println("-------------------------------------");
                    int amountWith = sc.nextInt();
                    withdraw(amountWith);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("--------------------------------------");
                    getPreviousTransaction();
                    System.out.println("--------------------------------------");
                    System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("*********************************************************************");
                    break;
                default:
                    System.out.println("Invalid option!!.Please enter again");
                    break;
            }
        } while (option != 'E');
        System.out.println("ThankYou for using our services");
    }

    void customerList() {
        System.out.println("Bank Customer List : ");

        Map<Integer, String> data = new HashMap<>();
        data.put(1, customerName);
        System.out.println(data);
    }
}
