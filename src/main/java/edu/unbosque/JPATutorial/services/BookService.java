package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.repositories.AuthorRepository;
import edu.unbosque.JPATutorial.jpa.repositories.AuthorRepositoryImpl;
import edu.unbosque.JPATutorial.jpa.repositories.BookRepository;
import edu.unbosque.JPATutorial.jpa.repositories.BookRepositoryImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Stateless
public class BookService {

    AuthorRepository authorRepository;
    BookRepository bookRepository;

    public void saveBook(String title, String isbn, Integer authorId, String genre) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        bookRepository = new BookRepositoryImpl(entityManager);

        Optional<Author> author = authorRepository.findById(authorId);
        author.ifPresent(a -> {
            a.addBook(new Book(title, isbn, genre));
            authorRepository.save(a);
        });

        entityManager.close();
        entityManagerFactory.close();

        return;

    }
    public boolean deleteBook(Integer authorId, Integer id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        bookRepository = new BookRepositoryImpl(entityManager);

        if(bookRepository.deleteBook(authorId, id)){
            entityManager.close();
            entityManagerFactory.close();
            return true;
        }
        entityManager.close();
        entityManagerFactory.close();
        return false;
    }

    public boolean modifyBook(Integer bookId, String title, String isbn, String genre){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        authorRepository = new AuthorRepositoryImpl(entityManager);
        bookRepository = new BookRepositoryImpl(entityManager);

        if(bookRepository.modifyBook(bookId, title, isbn, genre)){
            entityManager.close();
            entityManagerFactory.close();
            return true;
        }
        entityManager.close();
        entityManagerFactory.close();
        return false;
    }

}
