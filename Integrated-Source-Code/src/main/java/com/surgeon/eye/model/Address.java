package com.surgeon.eye.model;

import java.util.Date;

import lombok.Data;
@Data
public class Address {
    private String street;
    private String apartment;
    private String city;
    private String state;
    private int pin;


}