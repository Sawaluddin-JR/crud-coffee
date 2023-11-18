package com.ahtcoffee.crudcoffee.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahtcoffee.crudcoffee.models.Coffee;
import com.ahtcoffee.crudcoffee.repositories.CoffeeRepository;

@Controller
public class CoffeeController {
    @Autowired
    // private CoffeeService coffeeService;
    private CoffeeRepository coffeeRepository;

    @GetMapping("/list-coffee")
    public String listCoffee(Model model) {
        // List<Coffee> coffees = coffeeService.getAllCoffee();
        // model.addAttribute("coffees", coffees);
        model.addAttribute("coffees", coffeeRepository.findAll());
        return "list-coffee";
    }

    @GetMapping("/add")
    public String addCoffee(Model model) {
        Coffee coffee = new Coffee();
        // model.addAttribute("coffee", coffee);
        model.addAttribute("coffee", coffee);
        return "add-coffee";
    }

    // @PostMapping("/add-save")
    // public String saveCoffee(Coffee coffee) {
    // coffeeService.addCoffee(coffee);
    // return "redirect:/list-coffee";
    // }

    @PostMapping("/add-save")
    public String saveCoffee(@ModelAttribute("coffee") Coffee coffee) {
        coffeeRepository.save(coffee);
        return "redirect:/list-coffee";
    }

    // @GetMapping("/edit/{code}")
    // public String editCoffee(@PathVariable Integer code, Model model) {
    //     Coffee coffee = coffeeService.getCoffeById(code);
    //     model.addAttribute("coffee", coffee);
    //     return "update-coffee";
    // }
     @GetMapping("/edit/{code}")
    public String editCoffee(@PathVariable(value = "code" ) Integer code, Model model) {
        Coffee coffee = coffeeRepository.getReferenceById(code);
        model.addAttribute("coffee", coffee);
        return "update-coffee";
    }

    // @PostMapping("/update/{code}")
    // public String updateCoffee(@PathVariable Integer code, @ModelAttribute("coffee") Coffee upCoffee) {
    //     coffeeService.updateCoffee(code, upCoffee);
    //     return "redirect:/list-coffee";
    // }

    // @GetMapping("/delete/{code}")
    // public String deleteCoffee(@PathVariable Integer code) {
    //     coffeeService.deleteCoffee(code);
    //     return "redirect:/list-coffee";
    // }

    @GetMapping("/delete/{code}")
    public String deleteCoffee(@PathVariable(value = "code") Integer code) {
        coffeeRepository.deleteById(code);
        return "redirect:/list-coffee";
    }


}
