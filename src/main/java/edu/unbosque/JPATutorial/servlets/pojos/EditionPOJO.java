package edu.unbosque.JPATutorial.servlets.pojos;

import java.util.ArrayList;
import java.util.List;

public class EditionPOJO {

    private int editionId;
    private String description;
    private String releaseYear;
    private int bookId;
    private List<LibraryPOJO> libraries = new ArrayList<>();

    public EditionPOJO(int editionId, String description, String releaseYear, int bookId) {
        this.editionId = editionId;
        this.description = description;
        this.releaseYear = releaseYear;
        this.bookId = bookId;
    }

    public void addLibrary(LibraryPOJO library){
        this.libraries.add(library);
    }
}
