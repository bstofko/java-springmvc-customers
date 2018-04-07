/**
 * @author Bob Stofko
 * @version $1.0$
 */

package com.heb.assignment1.model;

public class Customer {
    private String lastName;
    private String firstName;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String timeStamp;
    private int id;

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getTimeStamp() {

        return this.timeStamp;
    }

    public void setTimeStamp(String timeStamp) {

        this.timeStamp = timeStamp;
    }

    public String toString() {

        return "Customer # " + this.id + "\n" + this.lastName + " " + this.firstName + "\n" + this.email + "\n" + this.address + "\n" + this.city + ", " + this.state + " " + this.zip + "\n";
    }
}
