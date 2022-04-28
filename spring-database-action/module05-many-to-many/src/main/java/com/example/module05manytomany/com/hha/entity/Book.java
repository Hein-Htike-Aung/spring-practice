package com.example.module05manytomany.com.hha.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bookName;

    private int publishedYear;

    @ManyToMany(mappedBy = "bookList")
    private List<Author> authors = new ArrayList<>();

    public Book() {
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
        author.getBookList().add(this);
    }

    public void removeAuthor(Author author){
        this.authors.remove(author);
        author.getBookList().remove(this);
    }

    public void addAuthors(List<Author> authorList) {
        this.authors.addAll(authorList);
        authorList.stream().map(author -> author.getBookList().add(this));
    }

    public void removeAuthors() {

        this.authors.forEach(author -> author.getBookList().removeIf(book -> book.equals(this)));

        this.authors.clear();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return bookName.equals(book.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName);
    }
}
