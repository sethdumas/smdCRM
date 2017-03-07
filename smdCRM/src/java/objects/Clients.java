/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objects;

import java.io.Serializable;

public class Clients implements Serializable {

    private int id;
    private String firstname;
    private String lastname;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    private boolean prospect;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isProspect() {
        return prospect;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProspect(boolean prospect) {
        this.prospect = prospect;
    }

  
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.id + ";");
        buffer.append("Name: " + this.firstname + this.lastname);
        buffer.append("Company: " + this.company +";");
        buffer.append("Address 1: " + this.address1 +":");
        buffer.append("Address 2: " + this.address2 +":");
        buffer.append("City: " + this.city +":");
        buffer.append("State: " + this.state +":");
        buffer.append("ZIP Code: " + this.zip +":");
        buffer.append("Phone Number: " + this.phone +":");
        buffer.append("Email: " + this.email +":");
        return buffer.toString();
    }
}
