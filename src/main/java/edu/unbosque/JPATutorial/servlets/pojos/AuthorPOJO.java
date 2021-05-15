package edu.unbosque.JPATutorial.servlets.pojos;

import edu.unbosque.JPATutorial.jpa.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class AuthorPOJO {

    private Integer authorId;

    private String name;

    private String country;

    private Integer numBooks;

    private List<BookPOJO> books = new ArrayList<>();

    public AuthorPOJO(Integer authorId, String name, String country, Integer numBooks) {
        this.authorId = authorId;
        this.name = name;
        this.country= country;
        this.numBooks = numBooks;
        this.books.clear();
    }
    public void addBook(BookPOJO book){
        this.books.add(book);
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumBooks() {
        return numBooks;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setNumBooks(Integer numBooks) {
        this.numBooks = numBooks;
    }

    public List<BookPOJO> getBooks() {
        return books;
    }

    public void setBooks(List<BookPOJO> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "AuthorPOJO{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", numBooks=" + numBooks +
                '}';
    }
}
