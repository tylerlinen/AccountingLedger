package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = null;

    public static void homeScreen() throws IOException {
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
    }

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

        scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        switch (value) {
            case "A":
                displayAll();
                break;
            case "D":
                displayDeposits();
                break;
            case "P":
                displayPayments();
                break;
            case "R":
                displayReports();
                break;
            case "H":
                homeScreen();
                break;
        }
    }

    public static void displayAll() throws IOException {
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

            System.out.println(t);

        }
    }

    public static void displayDeposits() throws IOException {
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

            if (deposit == true) {
                System.out.println(t);
            }

        }
    }

    public static void displayPayments() throws IOException {
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

            if (deposit == false) {
                System.out.println(t);
            }
        }
    }
    public static void monthToDate() throws IOException {
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

            LocalDate currentDate = LocalDate.now();
            Month month = currentDate.getMonth();

            Month m = date.getMonth();

            if (month.equals(m)){
                System.out.println(t);
            }

        }
    }
    public static void previousMonth() throws IOException {
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

            LocalDate currentDate = LocalDate.now().minusMonths(1);
            Month month = currentDate.getMonth();
            Month m = date.getMonth();

            if (month.equals(m)){
                System.out.println(t);
            }

        }
    }
    public static void yearToDate() throws IOException {
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

            LocalDate currentDate = LocalDate.now();
            int year = currentDate.getYear();
            int y = date.getYear();

            if (year == y){
                System.out.println(t);
            }

        }
    }
    public static void previousYear() throws IOException {
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

            LocalDate currentDate = LocalDate.now().minusYears(1);
            int year = currentDate.getYear();
            int y = date.getYear();

            if (year == y){
                System.out.println(t);
            }

        }
    }

    public static void displayReports() throws IOException {
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search By Vendor");
        System.out.println("6) Back");

        scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        switch (value){
            case "1":
                monthToDate();
                break;
            case "2":
               previousMonth();
                break;
            case "3":
                yearToDate();
                break;
            case "4":
                previousYear();
                break;
            case "5":
                monthToDate();
                break;
            case "6":
                monthToDate();
                break;
        }

    }
    public static void main(String[] args) {
        try {
            homeScreen();
        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }
}