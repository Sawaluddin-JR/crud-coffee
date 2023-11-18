package com.ahtcoffee.crudcoffee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahtcoffee.crudcoffee.models.Barista;
import com.ahtcoffee.crudcoffee.repositories.BaristaRepository;

@Controller
public class BaristaController {
    @Autowired
    private BaristaRepository baristaRepository;

    @GetMapping("home")
    public String allBarista(Model model) {
        model.addAttribute("baristas", baristaRepository.findAll());
        return "show-barista";
    }

    @GetMapping("add-barista")
    public String addBarista(Model model) {
        Barista barista = new Barista();
        model.addAttribute("barista", barista);
        return "save-barista";
    }

    @PostMapping("/save")
    public String saveBarista(@ModelAttribute("barista") Barista barista) {
        baristaRepository.save(barista);
        return "redirect:/home";
    }

    @GetMapping("/ebarista/{id}")
    public String updateBarista(@PathVariable(value = "id") Integer id, Model model) {
        Barista barista = baristaRepository.getReferenceById(id);
        model.addAttribute("barista", barista);
        return "update-barista";
    }

    @GetMapping("del/{id}")
    public String deleteBarista(@PathVariable(value = "id") Integer id) {
       baristaRepository.deleteById(id);
        return "redirect:/home";
    }

}
