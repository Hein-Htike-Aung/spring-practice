package com.example.module05manytomany.com.hha.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.*;
import java.util.function.Predicate;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String authorName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> bookList = new HashSet<>();

    public void addBook(Book book) {
        this.bookList.add(book);

        book.getAuthors().add(this);
    }

    public void removeBook(Book book) {
        this.bookList.remove(book);

        book.getAuthors().remove(this);

    }

    public void addBooks(List<Book> books) {
        this.bookList.addAll(books);
        books.stream().map(book -> book.getAuthors().add(this));
    }

    public void removeBooks() {

        this.bookList.stream()
                .map(book -> book.getAuthors().remove(this));
        this.bookList.clear();

    }

    public Author() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(authorName, author.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorName);
    }
}
