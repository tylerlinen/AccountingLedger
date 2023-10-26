package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {

    //Parametrized Constructor
    public Transaction(LocalDate date, LocalDateTime time, String description, String vendor, double amount, boolean deposit) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
        this.deposit = deposit;
    }
    // Data Members
    private LocalDate date;
    private LocalDateTime time;
    private String description;
    private String vendor;
    private double amount;
    private boolean deposit;


    @Override
    public String toString() {
        return "Transaction: " +
                "date=" + date +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", amount=" + amount +
                ", deposit=" + deposit;
    }
}
