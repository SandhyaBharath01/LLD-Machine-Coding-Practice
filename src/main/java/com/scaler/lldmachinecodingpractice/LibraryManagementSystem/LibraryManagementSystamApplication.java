package com.scaler.lldmachinecodingpractice.LibraryManagementSystem.Models;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LibraryManagementSystamApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementSystamApplication.class, args);
        LibraryManager libraryManager = LibraryManager.getInstance();

        //add books
        libraryManager.addBook(new Book("java", "javaAuthor", "123", "2020"));
        libraryManager.addBook(new Book("sql", "sqlAuthor", "112", "2000"));
        libraryManager.addBook(new Book("dsa", "dsaAuthor", "134", "2022"));
        libraryManager.addBook(new Book("lld", "lldAuthor", "156", "2021"));
        libraryManager.addBook(new Book("hld", "hldAuthor", "118", "2003"));

        //add members
        libraryManager.registerMember(new Member("1", "Sandhya", "9939"));
        libraryManager.registerMember(new Member("2", "Bharath", "9392"));
        libraryManager.registerMember(new Member("3", "Mahaan", "9553"));
        libraryManager.registerMember(new Member("4", "Vihaan", "7989"));
        libraryManager.registerMember(new Member("5", "Rekha", "7702"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a keyword to search for books: ");
        String keyword = scanner.nextLine();

        //Search books
        List<Book> searchResults = libraryManager.searchBooks(keyword);
        System.out.println("Search Results:");
        if (searchResults.isEmpty()) {
            System.out.println("No books found for the keyword: " + keyword);
        } else {
            for (Book book : searchResults) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
        // Borrow a book
        System.out.print("Enter the ISBN of the book you want to borrow: ");
        String borrowIsbn = scanner.nextLine();
        System.out.print("Enter your member ID: ");
        String memberId = scanner.nextLine();
        libraryManager.borrowBook(memberId, borrowIsbn);

        // Return a book
        System.out.print("Enter the ISBN of the book you want to return: ");
        String returnIsbn = scanner.nextLine();
        libraryManager.returnBook(memberId, returnIsbn);

        scanner.close();
    }

}
