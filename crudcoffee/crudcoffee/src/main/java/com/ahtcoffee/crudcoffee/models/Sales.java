package com.ahtcoffee.crudcoffee.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    // private String date;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "code_coffee", referencedColumnName = "code")
    private Coffee codeCoffee;

    @ManyToOne
    @JoinColumn(name = "id_barista", referencedColumnName = "id")
    private Barista idBarista;
}
