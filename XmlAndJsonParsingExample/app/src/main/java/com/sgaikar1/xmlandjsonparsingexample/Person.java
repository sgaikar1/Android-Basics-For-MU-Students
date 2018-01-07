package com.sgaikar1.xmlandjsonparsingexample;

import java.util.List;

/**
 * Created by Santosh Gaikar on 18/12/17.
 */

public class Person {

    private String name;
    private String surname;
    private Address address;
    private List<PhoneNumber> phoneList;

    public Person(String name, String surname, Address address, List<PhoneNumber> phoneList) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneList = phoneList;
    }

    // get and set

    public static class Address {
        private String address;
        private String city;
        private String state;

        public Address(String address, String city, String state) {
            this.address = address;
            this.city = city;
            this.state = state;
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
        // get and set
    }

    public static class PhoneNumber {
        private String type;
        private String number;

        public PhoneNumber(String type, String number) {
            this.type = type;
            this.number = number;
        }

        public String getNumber() {
            return number;
        }

        public String getType() {
            return type;
        }

        // get and set
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<PhoneNumber> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<PhoneNumber> phoneList) {
        this.phoneList = phoneList;
    }
}