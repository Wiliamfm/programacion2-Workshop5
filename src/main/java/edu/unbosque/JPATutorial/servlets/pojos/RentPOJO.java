package edu.unbosque.JPATutorial.servlets.pojos;

import java.util.Date;

public class RentPOJO {

    private int id;
    private String email;
    // private int editionId;
    private Date rentingDate;

    public RentPOJO(int id, String email, Date rentingDate) {
        this.id = id;
        this.email = email;
        this.rentingDate = rentingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(Date rentingDate) {
        this.rentingDate = rentingDate;
    }
}
