package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String s = "0889-02-19|2016-11-09 10:30|ergonomic keyboard|Amazon|-89.50\n";

        try {

            FileWriter fileWriter = new FileWriter("ledger.csv");
            fileWriter.write(s);
            fileWriter.close();


            FileReader fileReader = new FileReader("ledger.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String user = bufferedReader.readLine();
            String[] userData = user.toString().split("\\|");


            LocalDate date = LocalDate.parse(userData[0]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime time = LocalDateTime.parse(userData[1], formatter);
            String description = userData[2];
            String vendor = userData[3];
            double amount = Double.parseDouble(userData[4]);

            Transaction t = new Transaction(date, time, description, vendor, amount);

            System.out.println(t);

        } catch (Exception e) {
            e.printStackTrace();
        }


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