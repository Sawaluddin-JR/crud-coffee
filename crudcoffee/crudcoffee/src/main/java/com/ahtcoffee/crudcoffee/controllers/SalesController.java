package com.ahtcoffee.crudcoffee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahtcoffee.crudcoffee.models.Sales;
import com.ahtcoffee.crudcoffee.repositories.BaristaRepository;
import com.ahtcoffee.crudcoffee.repositories.CoffeeRepository;
import com.ahtcoffee.crudcoffee.repositories.SalesRepository;

@Controller
public class SalesController {
    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private BaristaRepository baristaRepository;

    @Autowired
    private CoffeeRepository coffeeRepository;

    @GetMapping("/sales")
    public String showSales(Model model) {
        model.addAttribute("sales", salesRepository.findAll());
        return "show-sales";
    }

    @GetMapping("/add-sales")
    public String addSales(Model model) {
        Sales sales = new Sales();
        model.addAttribute("sales", sales);
        model.addAttribute("kopi", coffeeRepository.findAll());
        model.addAttribute("baris", baristaRepository.findAll());
        return "save-sales";
    }

    @PostMapping("/save-sale")
    public String saveSales(@ModelAttribute("sales") Sales sales) {
        salesRepository.save(sales);
        return "redirect:/sales";
    }

    @GetMapping("/up-sales/{id}")
    public String updateSales(@PathVariable(value = "id") Integer id, Model model) {
        // Perlu memastikan pengambilan data yang dapat dimanipulasi, bukan hanya
        // referensi
        Sales sales = salesRepository.findById(id).orElse(null);
        if (sales != null) {
            model.addAttribute("sales", sales);
            return "update-sales";
        } else {
            // Handle jika tidak menemukan data dengan id tertentu
            return "redirect:/sales"; // Misalnya, redirect ke halaman sales
        }

        // Sales sales = salesRepository.getReferenceById(id);
        // model.addAttribute("sales", sales);
        // return "update-sales";
    }

    @GetMapping("/del-sales/{id}")
    public String deleteSales(@PathVariable(value = "id") Integer id) {
        salesRepository.deleteById(id);
        return "redirect:/sales";
    }
}
