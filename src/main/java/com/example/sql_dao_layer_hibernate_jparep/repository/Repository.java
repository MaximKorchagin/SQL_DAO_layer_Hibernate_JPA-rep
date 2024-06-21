package com.example.sql_dao_layer_hibernate_jparep.repository;

import com.example.sql_dao_layer_hibernate_jparep.model.PersonConfirmation;
import com.example.sql_dao_layer_hibernate_jparep.model.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Persons> getPersonsByCity(String city) {
        Query query = entityManager.createQuery("SELECT p FROM Persons p WHERE p.cityOfLiving = :city");
        query.setParameter("city", city);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        fillTable();
    }

    public void fillTable() {
        var names = List.of("Ivan", "Petr", "Olga", "Elena", "Oleg", "Olga");
        var surnames = List.of("Ivanov", "Petrov", "Frolova", "Sidorova", "Semenov", "Filatova");
        var ages = List.of(18, 20, 38, 22, 52, 42);
        var phone_numbers = List.of("8(921)123-00-11", "8(921)123-00-22", "8(921)123-00-33",
                "8(921)123-00-44", "8(921)123-00-55", "8(921)123-00-66");
        var cites = List.of("Moscow", "Moscow", "Orel", "Novosibirsk", "S-Pb", "Moscow");

        for (int i = 0; i < names.size(); i++) {
            var person = Persons.builder()
                    .personConfirmation(PersonConfirmation.builder()
                            .name(names.get(i))
                            .surname(surnames.get(i))
                            .age(ages.get(i))
                            .build())
                    .phoneNumber(phone_numbers.get(i))
                    .cityOfLiving(cites.get(i))
                    .build();

            entityManager.persist(person);
        }

    }
}