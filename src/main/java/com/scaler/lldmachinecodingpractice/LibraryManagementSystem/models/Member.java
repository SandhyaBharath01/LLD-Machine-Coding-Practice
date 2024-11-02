package com.scaler.lldmachinecodingpractice.LibraryManagementSystem.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Member {
    private String memberId;
    private String name;
    private String contactNumber;
    private List<Book> booksBorrowed;

    public Member(String memberId, String name, String contactNumber) {
        this.memberId = memberId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.booksBorrowed = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        booksBorrowed.add(book);
    }

    public void returnBook(Book book) {
        booksBorrowed.remove(book);
    }

    public List<Book> getBorrowedBooks() {
        return booksBorrowed;
    }

}
