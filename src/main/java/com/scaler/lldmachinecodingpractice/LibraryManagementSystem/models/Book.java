package com.scaler.lldmachinecodingpractice.LibraryManagementSystem.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private String publicationYear;
    private boolean isAvailabile;

    public Book(String title, String author, String ISBN, String publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.isAvailabile = true;
    }
}
