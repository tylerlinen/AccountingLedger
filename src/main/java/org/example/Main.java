package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = null;

    public static void makeDeposit() throws IOException {
        //Deposit
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date in format YYYY-MM-DD");
        String d = scanner.nextLine();
        System.out.println("Enter time in format yyyy-MM-dd HH:mm");
        String tod = scanner.nextLine();
        System.out.println("Enter description");
        String des = scanner.nextLine();
        System.out.println("Enter vendor");
        String v = scanner.nextLine();
        System.out.println("Enter Amount");
        String a = scanner.nextLine();

        String s = d + "|" + tod + "|" + des + "|" + v + "|" + a + "\n";

        FileWriter fileWriter = new FileWriter("ledger.csv");
        fileWriter.write(s);
        fileWriter.close();


        FileReader fileReader = new FileReader("ledger.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String user;
        while ((user = bufferedReader.readLine()) != null) {
            String[] userData = user.toString().split("\\|");


            LocalDate date = LocalDate.parse(userData[0]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime time = LocalDateTime.parse(userData[1], formatter);
            String description = userData[2];
            String vendor = userData[3];
            double amount = Double.parseDouble(userData[4]);
            boolean deposit = Boolean.parseBoolean(userData[5]);

            Transaction t = new Transaction(date, time, description, vendor, amount, deposit);
        }
    }

    public static void makePayment() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date in format YYYY-MM-DD");
        String d = scanner.nextLine();
        System.out.println("Enter time in format yyyy-MM-dd HH:mm");
        String tod = scanner.nextLine();
        System.out.println("Enter description");
        String des = scanner.nextLine();
        System.out.println("Enter vendor");
        String v = scanner.nextLine();
        System.out.println("Enter Amount");
        String a = scanner.nextLine();

        String s = d + "|" + tod + "|" + des + "|" + v + "|" + a + "\n";

        FileWriter fileWriter = new FileWriter("ledger.csv");
        fileWriter.write(s);
        fileWriter.close();


        FileReader fileReader = new FileReader("ledger.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String user;
        while ((user = bufferedReader.readLine()) != null) {
            String[] userData = user.toString().split("\\|");


            LocalDate date = LocalDate.parse(userData[0]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime time = LocalDateTime.parse(userData[1], formatter);
            String description = userData[2];
            String vendor = userData[3];
            double amount = Double.parseDouble(userData[4]);
            boolean deposit = Boolean.parseBoolean(userData[5]);

            Transaction t = new Transaction(date, time, description, vendor, amount, deposit);
        }
    }

    public static void ledgerScreen(){
        System.out.println("Ledger");
        System.out.println("A) Display All");
        System.out.println("D) Display All Deposits");
        System.out.println("P) Display Negative Entries");
        System.out.println("R) Reports");
        System.out.println("H) Home");

        String l = scanner.nextLine();
        String input = null;

        switch (l) {
            case "A":
                System.out.println("hello");
                break;
            case "D":
                System.out.println("hi");
                break;
            case "P":
                System.out.println("displayed negative entries");
                break;
            case "R":
                System.out.println("displayed reports");
                break;
            case "H":
                System.out.println("displayed home");
                break;
        }
    }

    public static void main(String[] args) {
        try {

            //Home Screen
            System.out.println("Home Screen");
            System.out.println("D)" + "Add Deposit");
            System.out.println("P)" + "Make Payment (Debit)");
            System.out.println("L)" + "Ledger");
            System.out.println("X)" + "Exit");

            scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            switch (choice) {
                case "D":
                    makeDeposit();
                    break;
                case "P":
                    makePayment();
                    break;
                case "L":
                    ledgerScreen();
                    break;
                case "X":
                    System.out.println("X)" + "Exit");
                    break;
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }
//

//        System.out.println("D)" + "Add Deposit");
//        System.out.println("P)" + "Make Payment (Debit)");
//        System.out.println("L)" + "Ledger");
//        System.out.println("X)" + "Exit");
//
//        Scanner scanner = new Scanner(System.in);
//
//        String choice = scanner.nextLine();
//
//        switch (choice){
//            case "D":
//                System.out.println("D)" + "Add Deposit");
//                break;
//            case "P":
//                System.out.println("P)" + "Make Payment (Debit)");
//                break;
//            case "L":
//                System.out.println("L)" + "Ledger");
//                break;
//            case "X":
//                System.out.println("X)" + "Exit");
//                break;
//        }


    }
}