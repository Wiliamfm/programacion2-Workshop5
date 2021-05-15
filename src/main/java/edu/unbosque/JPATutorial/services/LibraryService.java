package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Library;
import edu.unbosque.JPATutorial.jpa.repositories.LibraryRepository;
import edu.unbosque.JPATutorial.jpa.repositories.LibraryRepositoryImpl;

import edu.unbosque.JPATutorial.servlets.pojos.LibraryPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class LibraryService {

    LibraryRepository libraryRepository;

    public List<LibraryPOJO> listLibraries() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        libraryRepository = new LibraryRepositoryImpl(entityManager);
        List<Library> libraries = libraryRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<LibraryPOJO> librariesPOJO = new ArrayList<>();
        for (Library library : libraries) {
            librariesPOJO.add(new LibraryPOJO(
                    library.getLibraryId(),
                    library.getName()
            ));
        }

        return librariesPOJO;

    }

    public void saveLibrary(String name) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        libraryRepository = new LibraryRepositoryImpl(entityManager);

        Library library = new Library(name);
        Library persistedLibrary = libraryRepository.save(library).get();

        entityManager.close();
        entityManagerFactory.close();

    }

    public boolean delete(Integer id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Library library = entityManager.find(Library.class, id);
        if(library!=null){
            entityManager.getTransaction().begin();
            entityManager.remove(library);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            return true;
        }else{
            entityManager.close();
            entityManagerFactory.close();
            return false;
        }
    }

    public boolean modify(Integer id, String name){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Library library = entityManager.find(Library.class, id);
        if(library!=null){
            entityManager.getTransaction().begin();
            library.setName(name);
            entityManager.getTransaction().commit();
            entityManager.close();
            entityManagerFactory.close();
            return true;
        }else{
            entityManager.close();
            entityManagerFactory.close();
            return false;
        }

    }

}
