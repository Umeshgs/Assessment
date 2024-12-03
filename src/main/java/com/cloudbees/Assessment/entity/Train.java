package com.cloudbees.Assessment.entity;

public class Train {
    private String section;
    private int section1Seats;
    private int section2Seats;

    private static Train train;

    private Train() {
        section = "Section 1";
        section1Seats = 20;
        section2Seats = 20;
    }

    public static Train getTrain() {
        if(train == null) {
            train = new Train();
        }
        return train;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getSeats() {
        if(getSection().equals("Section 1")) {
            return section1Seats;
        }
        else {
            return section2Seats;
        }
    }

    public int bookSeat(String section) {
        if(getSection().equals("Section 1")) {
            return this.section1Seats--;
        }
        else {
            return this.section2Seats--;
        }
    }
}
