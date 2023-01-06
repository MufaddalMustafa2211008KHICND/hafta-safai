package com.glc.haftasafai.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="volunteers")
public class Volunteers {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String city;
    private String email;
    private String password;
    private Boolean isRegistered;


    protected Volunteers() {}


    public Volunteers(String firstName, String lastName, String gender, Integer age, String city, String email,
            String password, Boolean isRegistered) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.email = email;
        this.password = password;
        this.isRegistered = isRegistered;
    }

}
