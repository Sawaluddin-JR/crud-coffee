package com.ahtcoffee.crudcoffee.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer code;
    private String merk;
    private String type;
    private Long price;

    // public Coffee() {
    // }

    // public Coffee(Integer code, String merk, String type, Long price) {
    //     this.code = code;
    //     this.merk = merk;
    //     this.type = type;
    //     this.price = price;

    // }

    // public Integer getCode() {
    //     return code;
    // }

    // public void setCode(Integer code) {
    //     this.code = code;
    // }

    // public String getMerk() {
    //     return merk;
    // }

    // public void setMerk(String merk) {
    //     this.merk = merk;
    // }

    // public String getType() {
    //     return type;
    // }

    // public void setType(String type) {
    //     this.type = type;
    // }

    // public Long getPrice() {
    //     return price;
    // }

    // public void setPrice(Long price) {
    //     this.price = price;
    // }

}
