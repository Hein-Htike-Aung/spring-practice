package com.example.module05manytomany.com.hha.service;

import com.example.module05manytomany.com.hha.dao.AuthorDao;
import com.example.module05manytomany.com.hha.dao.BookDao;
import com.example.module05manytomany.com.hha.entity.Author;
import com.example.module05manytomany.com.hha.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private BookDao bookDao;

    @Transactional
    public void saveAuthorsWithBooks() {

        Author author = new Author();
        author.setAuthorName("Xiaoting");
        Author author2 = new Author();
        author2.setAuthorName("Karina");

        Book book = new Book();
        book.setBookName("Atomic Habit");
        book.setPublishedYear(2020);
        Book book2 = new Book();
        book2.setBookName("INTJ");
        book2.setPublishedYear(2020);
        Book book3 = new Book();
        book3.setBookName("How to Use your brain");
        book3.setPublishedYear(2019);

        author.addBooks(List.of(book, book2));
        author2.addBooks(List.of(book2, book3));

        authorDao.save(author);
        authorDao.save(author2);
    }

    @Transactional
    public void findAuthorWithBooks() {
        Author author = authorDao.getById(2);

        System.out.println(author.getAuthorName());

        author.getBookList().stream()
                .map(book -> book.getBookName() + " : " + book.getPublishedYear())
                .forEach(System.out::println);
    }

    @Transactional
    public void removeAllBooksByAuthorId2() {
        Author author = authorDao.getById(2);

        author.removeBooks();
    }
}
