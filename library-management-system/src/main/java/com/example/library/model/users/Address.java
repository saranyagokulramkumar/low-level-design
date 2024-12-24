package com.example.library.model.users;

import lombok.Data;

@Data
public class Address {
    private String name;
    private String city;
    private String state;
    private int zipCode;
    private String country;
}
