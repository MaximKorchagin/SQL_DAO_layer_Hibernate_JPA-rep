package com.example.sql_dao_layer_hibernate_jparep.controller;

import com.example.sql_dao_layer_hibernate_jparep.model.Persons;
import com.example.sql_dao_layer_hibernate_jparep.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(@RequestParam String city) {
        System.out.println(city);
        return service.getPersonsByCity(city);
    }
}