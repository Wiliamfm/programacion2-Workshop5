package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {

    private EntityManager entityManager;

    public BookRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Book> findById(Integer id) {
        Book book = entityManager.find(Book.class, id);
        return book != null ? Optional.of(book) : Optional.empty();
    }

    public Optional<Book> findByTitle(String title) {
        Book book = entityManager.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class)
                .setParameter("title", title)
                .getSingleResult();
        return book != null ? Optional.of(book) : Optional.empty();
    }

    public Optional<Book> findByTitleNamedQuery(String title) {
        Book book = entityManager.createNamedQuery("Book.findByTitle", Book.class)
                .setParameter("title", title)
                .getSingleResult();
        return book != null ? Optional.of(book) : Optional.empty();
    }

    public List<Book> findAll() {
        return entityManager.createQuery("from Book").getResultList();
    }

    public Optional<Book> save(Book book) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();
            return Optional.of(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteBook(Integer authorId, Integer bookId) {
        Book book = entityManager.find(Book.class, bookId);
        Author author = entityManager.find(Author.class, authorId);
        if (book != null) {
            try {

                entityManager.getTransaction().begin();
                author.deleteBook(book.getBookId());
                entityManager.remove(book);
                entityManager.getTransaction().commit();
                return true;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }else {
            return false;
        }

    }

    @Override
    public boolean modifyBook(Integer bookId, String title, String isbn, String genre) {
        Book book = entityManager.find(Book.class, bookId);
        if(book != null){
            try{
                entityManager.getTransaction().begin();
                book.setTitle(title);
                book.setIsbn(isbn);
                book.setGenre(genre);
                entityManager.getTransaction().commit();
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }
}
