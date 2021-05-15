package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Book") // Optional
@NamedQueries({
        @NamedQuery(name = "Book.findByTitle",
                query = "SELECT b FROM Book b WHERE b.title = :title"),
        @NamedQuery(name = "Book.findAll",
                query = "SELECT b FROM Book b")
})
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Integer bookId;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(name = "isbn_number")
    private String isbn;

    @Column(nullable = false)
    private String genre;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Edition> edition = new ArrayList<>();

    public Book() {}

    public Book(String title, String isbn, String genre) {
        this.title = title;
        this.isbn = isbn;
        this.genre= genre;
    }

    public Book(Integer bookId, String title, String isbn, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.isbn = isbn;
        this.genre= genre;
    }

    public void addEdition(Edition edition) {
        this.edition.add(edition);
        edition.setBook(this);
    }
    public boolean deleteEdition(Integer editionId){
        for (Edition edition: this.getEdition()) {
            if(edition.getEditionId()==editionId){
                this.getEdition().remove(edition);
                return true;
            }
        }
        return false;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Edition> getEdition() {
        return edition;
    }

    public void setEdition(List<Edition> edition) {
        this.edition = edition;
    }
}
