package edu.unbosque.JPATutorial.servlets.pojos;

import java.util.ArrayList;
import java.util.List;

public class BookPOJO {

    private Integer bookId;
    private String title;
    private String isbn;
    private String genre;
    private List<EditionPOJO> editionPOJOList = new ArrayList<>();

    public BookPOJO(Integer bookId, String title, String isbn, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.isbn = isbn;
        this.genre = genre;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void addEdition(EditionPOJO editionPOJO){
        this.editionPOJOList.add(editionPOJO);
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

    public List<EditionPOJO> getEditionPOJOList() {
        return editionPOJOList;
    }

    public void setEditionPOJOList(List<EditionPOJO> editionPOJOList) {
        this.editionPOJOList = editionPOJOList;
    }
}
