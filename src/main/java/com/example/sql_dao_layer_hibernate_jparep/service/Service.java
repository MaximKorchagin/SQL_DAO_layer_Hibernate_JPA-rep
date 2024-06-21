package com.example.sql_dao_layer_hibernate_jparep.service;

import com.example.sql_dao_layer_hibernate_jparep.model.Persons;
import com.example.sql_dao_layer_hibernate_jparep.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<Persons> getPersonsByCity(String city) {
        if (isEmpty(city)) {
            return null;
        }
        return repository.getPersonsByCity(city);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}