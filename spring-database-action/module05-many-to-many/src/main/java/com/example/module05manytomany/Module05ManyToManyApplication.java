package com.example.module05manytomany;

import com.example.module05manytomany.com.hha.service.AuthorService;
import com.example.module05manytomany.com.hha.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module05ManyToManyApplication implements CommandLineRunner {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(Module05ManyToManyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        System.out.println("\nSave Author With Books");
//        authorService.saveAuthorsWithBooks();
//
//        System.out.println("\nFind Karina Books");
//        authorService.findAuthorWithBooks();
//
//        System.out.println("\nRemove All Karina Books");
//        authorService.removeAllBooksByAuthorId2();
//
//        System.out.println("\nFind Karina Books");
//        authorService.findAuthorWithBooks();

        System.out.println("\nSave Author With Books");
        authorService.saveAuthorsWithBooks();

        System.out.println("\nFind Atomic Habit's Authors");
        bookService.findBookWithAuthors();

        System.out.println("\nRemove All Atomic Habit's Authors");
        bookService.removeAllAuthors();

        System.out.println("\nFind Atomic Habit's Authors");
        bookService.findBookWithAuthors();
    }
}
