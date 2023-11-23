package Model;

import java.util.Date;

public class Entry {
    private Date date;
    private String description;
    private double amount;

    public Entry(Date date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    // Getter y Setter para date, description y amount
}
