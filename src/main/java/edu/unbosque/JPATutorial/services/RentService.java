package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.entities.Rent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RentService {

    public boolean rent(String email, Integer editionId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager= entityManagerFactory.createEntityManager();

        Customer customer= entityManager.find(Customer.class, email);
        Edition edition= entityManager.find(Edition.class, editionId);
        if(customer!=null && edition!=null){
            entityManager.getTransaction().begin();
            Rent rent= new Rent(java.time.LocalDate.now().toString());
            customer.addRent(rent);
            edition.addRent(rent);
            entityManager.persist(rent);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            return true;
        }
        entityManager.close();
        entityManagerFactory.close();
        return false;

    }
}
