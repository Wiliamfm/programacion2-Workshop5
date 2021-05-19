package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.entities.Rent;
import edu.unbosque.JPATutorial.servlets.pojos.RentPOJO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

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

    public List<RentPOJO> listRents(String email, String date){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager= entityManagerFactory.createEntityManager();

        try{

            List<Rent> rentList= entityManager.createQuery("select r from Rent r where r.rentingDate="+"'"+date+"' and r.customer="+"'"+email+"'").getResultList();
            List<RentPOJO> pojos= new ArrayList<>();
            for (Rent r :
                    rentList) {
                pojos.add(new RentPOJO(r.getRentId(), r.getCustomer().getEmail(), r.getRentingDate(), r.getEdition().getEditionId()));
            }
            entityManager.close();
            entityManagerFactory.close();
            return pojos;

        }catch (Exception e){

            Customer c= entityManager.find(Customer.class, email);
            List<RentPOJO> a= new ArrayList<>();

            a.add(new RentPOJO(-1, e.getMessage(), "date", -1));

            return a;

        }
    }

    public boolean delete(Integer id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager= entityManagerFactory.createEntityManager();

        Rent rent = entityManager.find(Rent.class, id);
        if(rent!=null){
            entityManager.getTransaction().begin();
            entityManager.remove(rent);
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
