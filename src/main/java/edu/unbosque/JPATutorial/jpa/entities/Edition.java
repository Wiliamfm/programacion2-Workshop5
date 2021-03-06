package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Edition") // Optional
@NamedQueries({
        @NamedQuery(name = "Edition.findAll",
                query = "SELECT b FROM Edition b")
})
public class Edition {

    @Id
    @GeneratedValue
    @Column(name = "edition_id")
    private Integer editionId;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Date releaseYear;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // FetchType.EAGER: When we retrieve a Library, we'll also automatically retrieve all of its corresponding Editions
    // CascadeType.PERSIST: When we save a superhero, its movies will also be saved
    @ManyToMany(mappedBy = "editions", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Library> libraries = new HashSet<>();

    @OneToMany(mappedBy = "edition", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Rent> rentList = new ArrayList<>();

    public Edition() {}

    public Edition(String description, Date releaseYear) {
        this.description = description;
        this.releaseYear = releaseYear;
    }

    public Edition(Integer editionId, String description, Date releaseYear) {
        this.editionId = editionId;
        this.description = description;
        this.releaseYear = releaseYear;
    }

    public void addLibrary(Library library) {
        libraries.add(library);
        library.getEditions().add(this);
    }

    public void removeLibrary(Library library){
        for (Library lib : this.libraries) {
                if (lib.getLibraryId() == library.getLibraryId()) {
                    libraries.remove(lib);
                    library.getEditions().remove(this);
                    break;
                }
            }
    }

    public void addRent(Rent rent){
        rentList.add(rent);
        rent.setEdition(this);
    }

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Set<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(Set<Library> libraries) {
        this.libraries = libraries;
    }

    public List<Rent> getRentList() {
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }
}
