//Create banking application using try , catch and finally block and specific exceptions .
package com.myException.basic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingApp {

    private static double balance = 1000.0; // Initial balance
    private static Scanner scanner = new Scanner(System.in); // Declare scanner as a static field

    public static void main(String[] args) {
        while (true) {
            // Display menu options
            System.out.println("\nWelcome to the Banking App!");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice:- ");

            // Get user choice
            int choice = scanner.nextInt();

            // Perform action based on user choice
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to check and display the current balance
    private static void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    // Method to withdraw money from the account
    private static void withdrawMoney() {
        try {
            // Prompt user for withdrawal amount
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();

            // Check if there is sufficient balance
            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient balance");
            }

            // Update balance after withdrawal
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } catch (InsufficientBalanceException e) {
            // Handle insufficient balance exception
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            // Handle invalid input exception
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.nextLine(); // Clear the invalid input
        } finally {
            // Display a thank you message
            System.out.println("Thank you for using the banking app.");
        }
    }

    // Method to deposit money into the account
    private static void depositMoney() {
        try {
            // Prompt user for deposit amount
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();

            // Update balance after deposit
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } catch (InputMismatchException e) {
            // Handle invalid input exception
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.nextLine(); // Clear the invalid input
        } finally {
            // Display a thank you message
            System.out.println("Thank you for using the banking app.");
        }
    }
}

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
