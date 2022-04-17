package com.example.va;

public class users {
    String name, address, car_model, vehicle_code, email, contact;
    public users(){
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVehicle_code() {
        return vehicle_code;
    }

    public void setVehicle_code(String vehicle_code) {
        this.vehicle_code = vehicle_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public users(String name, String address, String car_model, String vehicle_code, String email, String contact) {
        this.name = name;
        this.address = address;
        this.car_model = car_model;
        this.vehicle_code = vehicle_code;
        this.email=email;
        this.contact=contact;
    }
}
