package com.example.module05manytomany.com.hha.service;

import com.example.module05manytomany.com.hha.dao.AuthorDao;
import com.example.module05manytomany.com.hha.dao.BookDao;
import com.example.module05manytomany.com.hha.entity.Author;
import com.example.module05manytomany.com.hha.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private BookDao bookDao;

    @Transactional
    public void findBookWithAuthors() {
        Book book = bookDao.getById(1);

        System.out.println(book.getBookName());

        book.getAuthors().stream()
                .map(author -> author.getAuthorName())
                .forEach(System.out::println);
    }

    @Transactional
    public void removeAllAuthors() {
        Book book = bookDao.getById(1);

        book.removeAuthors();
    }

}
