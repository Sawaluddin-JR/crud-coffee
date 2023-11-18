package com.ahtcoffee.crudcoffee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ahtcoffee.crudcoffee.models.Coffee;

@Service
public class CoffeeService {
    private List<Coffee> coffees = new ArrayList<>();

    public List<Coffee> getAllCoffee() {
        return coffees;
    }

    public void addCoffee(Coffee coffee) {
        this.coffees.add(coffee);
    }

    public Coffee getCoffeById(Integer code) {
        for (Coffee coffee : coffees) {
            if (coffee.getCode().equals(code)) {
                return coffee;
            }
        }
        return null;
    }

    public void updateCoffee(Integer code, Coffee upCoffee) {
        Coffee coffee2 = getCoffeById(code);
        if (coffee2 != null) {
            coffee2.setCode(upCoffee.getCode());
            coffee2.setMerk(upCoffee.getMerk());
            coffee2.setType(upCoffee.getType());
            coffee2.setPrice(upCoffee.getPrice());
        }
    }
    public void deleteCoffee(Integer code){
        for (int i = 0; i < coffees.size(); i++) {
            if (coffees.get(i).getCode().equals(code)) {
                coffees.remove(i);
            }
        }
    }

   
}
