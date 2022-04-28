package com.example.module05manytomany.com.hha.dao;

import com.example.module05manytomany.com.hha.entity.Author;
import com.example.module05manytomany.com.hha.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorDao extends JpaRepository<Author, Integer> {


}
