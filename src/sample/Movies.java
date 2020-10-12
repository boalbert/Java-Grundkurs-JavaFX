package sample;

// Class for handling movie-objects

import java.io.Serializable;

public class Movies implements Serializable {

    private String title;
    private int seats = 20;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Movies(String title) {
        this.title = title;
    }
}
