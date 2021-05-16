package edu.unbosque.JPATutorial.servlets.pojos;

import java.util.Date;

public class RentPOJO {

    private int id;
    private String email;
     private int editionId;
    private String rentingDate;

    public RentPOJO(int id, String email, String rentingDate, int editionId) {
        this.id = id;
        this.email = email;
        this.rentingDate = rentingDate;
        this.editionId= editionId;
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

    public String getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(String rentingDate) {
        this.rentingDate = rentingDate;
    }

    public int getEditionId() {
        return editionId;
    }

    public void setEditionId(int editionId) {
        this.editionId = editionId;
    }
}
