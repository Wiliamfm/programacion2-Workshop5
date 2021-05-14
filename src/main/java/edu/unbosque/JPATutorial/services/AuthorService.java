package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.repositories.AuthorRepository;
import edu.unbosque.JPATutorial.jpa.repositories.AuthorRepositoryImpl;
import edu.unbosque.JPATutorial.servlets.pojos.AuthorPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.BookPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AuthorService {

    AuthorRepository authorRepository;

    public List<AuthorPOJO> listAuthors() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        List<Author> authors = authorRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<AuthorPOJO> authorsPOJO = new ArrayList<>();
        for (Author author : authors) {
            authorsPOJO.add(new AuthorPOJO(
                    author.getAuthorId(),
                    author.getName(),
                    author.getCountry(),
                    author.getBooks().size()
            ));
        }
        return authorsPOJO;

    }

    public Author saveAuthor(String name, String country) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);

        Author author = new Author(name, country);
        Author persistedAuthor = authorRepository.save(author).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedAuthor;

    }

    public void deleteAuthor(Integer authorId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        authorRepository.deleteById(authorId);

        entityManager.close();
        entityManagerFactory.close();

    }

    public void modifyAuthor(Integer authorId, String name, String country){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        Author author= new Author(name, country);
        authorRepository.modifyAuthor(authorId, author);

        entityManager.close();
        entityManagerFactory.close();
    }

    public AuthorPOJO getAuthorById(Integer id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        Author a =authorRepository.findById(id).get();
        AuthorPOJO author = new AuthorPOJO(a.getAuthorId(), a.getName(), a.getCountry(), a.getBooks().size());

        for (Book b: a.getBooks()) {
            author.addBook(new BookPOJO(b.getBookId(), b.getTitle(), b.getIsbn(), b.getGenre()));
        }

        entityManager.close();
        entityManagerFactory.close();

        //return a;
        return author;
    }

}
