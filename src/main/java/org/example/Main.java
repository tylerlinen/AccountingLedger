package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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


        String s = d + "|" + tod + "|" + des + "|" + v + "|" + a + "|" + true + "\n";

        FileWriter fileWriter = new FileWriter("ledger.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(s);
        bufferedWriter.close();
        fileWriter.close();

        //file reader append
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


        String s = d + "|" + tod + "|" + des + "|" + v + "|" + a + "|" + false + "\n";

        FileWriter fileWriter = new FileWriter("ledger.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(s);
        bufferedWriter.close();
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

    public static void ledgerScreen() throws IOException {
        System.out.println("Ledger");
        System.out.println("A) Display All");
        System.out.println("D) Display All Deposits");
        System.out.println("P) Display Negative Entries");
        System.out.println("R) Reports");
        System.out.println("H) Home");

        FileReader fileReader = new FileReader("ledger.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String user = null;


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

            String l = scanner.nextLine();

            if (l == "A"){
                System.out.println(deposit);
            }

        }




//            switch (l) {
//                case "A":
//                    System.out.println(user);
//                    break;
//                case "D":
//                    if (deposit == true) {
//                        System.out.println(t);
//                    } else {
//                        System.out.println("");
//                    }
//                    break;
//                case "P":
//                    if (deposit == false) {
//                        System.out.println(t);
//                    } else {
//                        System.out.println("");
//                    }
//                    break;
//                case "R":
//                    System.out.println("1) Month to Date");
//                    System.out.println("2) Previous Date");
//                    System.out.println("3) Year to Date");
//                    System.out.println("4) Previous Year");
//                    System.out.println("5) Search by Vendor");
//                    System.out.println("6) Back");
//
//                    String p = scanner.nextLine();
//
//                    switch (p) {
//                        case "1":
//                            System.out.println(1);
//                            break;
//                        case "2":
//                            System.out.println(2);
//                            break;
//                        case "3":
//                            System.out.println(3);
//                            break;
//                        case "4":
//                            System.out.println(4);
//                            break;
//                        case "5":
//                            System.out.println(5);
//                            break;
//                        case "6":
//                            System.out.println(6);
//                            break;
//                    }
//
//                    break;
//                case "H":
//                    System.out.println(2);
//                    break;
//
//        }
        bufferedReader.close();
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

    }
}