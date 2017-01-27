/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.Serializable;

public class Clients implements Serializable {

    private int id;
    private String name;
    private boolean prospect;
    private int phone;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String company;
    private int companyId;
    private String customersince;

    public void setId(int i) {
        id = i;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isProspect() {
        return prospect;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public String getCompany() {
        return company;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getCustomersince() {
        return customersince;
    }

    public void setProspect(boolean prospect) {
        this.prospect = prospect;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setCustomersince(String customersince) {
        this.customersince = customersince;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.id + ";");
        buffer.append("Name: " + name);
        return buffer.toString();
    }
}
