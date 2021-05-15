package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "Rent")
public class Rent {

    @Id
    @GeneratedValue
    @Column(name="rent_id")
    private Integer rentId;

    @ManyToOne
    @JoinColumn(name="email")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="edition_id")
    private Edition edition;

    @Column(name="renting_date")
    private String rentingDate;

    public Rent(){
    }

    public Rent(String rentingDate) {
        this.rentingDate = rentingDate;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(String rentingDate) {
        this.rentingDate = rentingDate;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }
}
