package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Edition;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

public class EditionService {

    public boolean save(int bookId, String description){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Book book = entityManager.find(Book.class, bookId);
        if(book != null){
            entityManager.getTransaction().begin();
            Edition edition = new Edition(description, new Date());
            entityManager.persist(edition);
            book.addEdition(edition);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            return true;
        }
        entityManager.close();
        entityManagerFactory.close();
        return false;
    }

    public boolean delete(Integer bookId, Integer editionId){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Book book= entityManager.find(Book.class, bookId);
        Edition edition= entityManager.find(Edition.class, editionId);
        if(edition!=null){
            entityManager.getTransaction().begin();
            book.deleteEdition(editionId);
            entityManager.remove(edition);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            return true;
        }
        entityManager.close();
        entityManagerFactory.close();
        return false;
    }

    public boolean modifyEdition(Integer id, String description){
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Edition edition = entityManager.find(Edition.class, id);
        if(edition != null){
            entityManager.getTransaction().begin();
            edition.setDescription(description);
            edition.setReleaseYear(new Date());
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }
}
