package edu.unbosque.JPATutorial.servlets.pojos;

import java.util.ArrayList;
import java.util.List;

public class CustomerPOJO {

    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private List<RentPOJO> rents= new ArrayList<>();

    public CustomerPOJO(String email, String firstName, String lastName, String gender, int age) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public void addRent(RentPOJO rent){
        rents.add(rent);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
