package com.cloudbees.Assessment.entity;

public class Ticket {
    private String fromStation;
    private String toStation;
    private User customer;

    public Ticket() {
    }

    public Ticket(String fromStation, String toStation, User customer) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "From: '" + fromStation + '\'' +
                ", To: '" + toStation + '\'' +
                ", Customer: " + customer +
                ", Amount paid: $20" +
                '}';
    }
}
