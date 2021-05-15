package edu.unbosque.JPATutorial.servlets.pojos;

public class EditionPOJO {

    private int editionId;
    private String description;
    private String releaseYear;
    private int bookId;

    public EditionPOJO(int editionId, String description, String releaseYear, int bookId) {
        this.editionId = editionId;
        this.description = description;
        this.releaseYear = releaseYear;
        this.bookId = bookId;
    }
}
