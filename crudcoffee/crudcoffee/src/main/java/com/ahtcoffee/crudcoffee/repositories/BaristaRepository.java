package com.ahtcoffee.crudcoffee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahtcoffee.crudcoffee.models.Barista;

public interface BaristaRepository extends JpaRepository<Barista,Integer> {

    
}
