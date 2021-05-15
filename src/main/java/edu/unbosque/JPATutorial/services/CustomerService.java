package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.servlets.pojos.CustomerPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private List<Customer> findAll(EntityManager entityManager){
        return entityManager.createQuery("from Customer").getResultList();
    }

    public List<CustomerPOJO> listCustomers(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Customer> customers = findAll(entityManager);
        entityManager.close();
        entityManagerFactory.close();
        List<CustomerPOJO> pojos = new ArrayList<>();
        for (Customer c :
                customers) {
            pojos.add(new CustomerPOJO(c.getEmail(), c.getFirstName(), c.getLastName(), c.getGender(), c.getAge()));
        }
        return pojos;
    }

    public boolean create(String email, String fName, String lName, String gender, int age){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(new Customer(email, fName, lName, gender, age));
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            return true;
        }catch (Exception e){
            entityManager.close();
            entityManagerFactory.close();
            return false;
        }
    }

    public boolean delete(String email){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Customer customer= entityManager.find(Customer.class, email);
        if(customer!=null){
            entityManager.getTransaction().begin();
            entityManager.remove(customer);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            return true;
        }
        entityManager.close();
        entityManagerFactory.close();
        return false;
    }

    public boolean modify(String email, String fName, String lName, String gender, int age){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Customer customer= entityManager.find(Customer.class, email);
        if(customer!=null){
            entityManager.getTransaction().begin();
            customer.setFirstName(fName);
            customer.setLastName(lName);
            customer.setGender(gender);
            customer.setAge(age);
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
