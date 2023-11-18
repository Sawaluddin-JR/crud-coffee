package com.ahtcoffee.crudcoffee.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data  // buat berinteraksi
@Entity // buat menghubungkan

public class Barista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // bedanya integer(primitif)dan dijava ini sebagai objk dan int(komposit)
    private String name;
    private int age;
    private String gender;
    private String email;


}
