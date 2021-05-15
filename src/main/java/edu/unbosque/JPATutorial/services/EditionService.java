package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.entities.Library;
import edu.unbosque.JPATutorial.servlets.pojos.EditionPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.LibraryPOJO;

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
            entityManager.close();
            entityManagerFactory.close();
            return true;
        }
        entityManager.close();
        entityManagerFactory.close();
        return false;
    }

    public EditionPOJO getEdition(Integer id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Edition edition= entityManager.find(Edition.class, id);EditionPOJO pojo = new EditionPOJO(edition.getEditionId(), edition.getDescription(), String.valueOf(edition.getReleaseYear()), edition.getBook().getBookId());
        if(edition!=null){

            for (Library lib :
                    edition.getLibraries()) {
                pojo.addLibrary(new LibraryPOJO(lib.getLibraryId(), lib.getName()));
            }
        }
        entityManager.close();
        entityManagerFactory.close();
        return pojo;
    }

    public void linkLibrary(Integer libraryId, Integer editionId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Library lib= entityManager.find(Library.class, libraryId);
        Edition ed= entityManager.find(Edition.class, editionId);
        entityManager.getTransaction().begin();
        ed.addLibrary(lib);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public void unLinkLibrary(Integer libraryId, Integer editionId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Library lib= entityManager.find(Library.class, libraryId);
        Edition ed= entityManager.find(Edition.class, editionId);
        entityManager.getTransaction().begin();
        ed.removeLibrary(lib);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
