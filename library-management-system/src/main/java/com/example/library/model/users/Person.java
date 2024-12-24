package com.example.library.model.users;

import lombok.Data;

@Data
public class Person {
    private String name;
    private Address address;
    private String email;
    private String phone;
}
