package com.scaler.lldmachinecodingpractice.LibraryManagementSystem.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class LibraryManager {
    private static LibraryManager instance;
    private Map<String, Book> catalogue;
    private Map<String, Member> members;
    private int maxBooks = 5;
    private int maxDuration = 14;

    //singleton principle
    private LibraryManager(){
        catalogue = new ConcurrentHashMap<>();
        members = new ConcurrentHashMap<>();
    }
    public static synchronized LibraryManager getInstance(){
        if(instance==null){
            instance = new LibraryManager();
        }
        return instance;
    }
    public void addBook(Book book){
        catalogue.put(book.getISBN(), book);
    }
    public void removeBook(String isbn){
        catalogue.remove(isbn);
    }
    public Book getBook(String isbn){
        return catalogue.get(isbn);
    }
    public void registerMember(Member member){
        members.put(member.getMemberId(), member);
    }
    public void removeMember(String memberId){
        members.remove(memberId);
    }
    public Member getMember(String memberId){
        return members.get(memberId);
    }
    public synchronized void borrowBook(String memberId, String isbn){
        Member member = getMember(memberId);
        Book book = getBook(isbn);
        if(member!=null && book!=null && book.isAvailabile()){
            if(member.getBooksBorrowed().size()<maxBooks){
                member.borrowBook(book);
                book.setAvailabile(false);
                System.out.println("Member with member id " +member.getName()+" has borrowed book with title " +book.getTitle());
            }else{
                System.out.println("Member with Member name " +member.getName()+" has reached maximum limit");
            }
        }else{
            System.out.println("Book or member or Book title not found please check again");
        }
    }
    public synchronized void returnBook(String memberId, String isbn){
        Member member = getMember(memberId);
        Book book = getBook(isbn);
        if(member!=null && book!=null){
            member.returnBook(book);
            book.setAvailabile(true);
            System.out.println("member with name " +member.getName()+" has returned book with name " +book.getTitle());
        }else{
            System.out.println("Book or member not found please check again");
        }
    }
    public List<Book> searchBooks(String keyword){
        List<Book> availableBooks = new ArrayList<>();
        for(Book book : catalogue.values()){
            if(book.getTitle().contains(keyword) || book.getAuthor().contains(keyword) && book.isAvailabile()){
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }


}
