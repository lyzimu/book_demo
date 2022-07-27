package com.example.demo.dao;


import com.example.demo.po.Book;
import com.example.demo.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookDao {

     List<Book> findBookAll();

    int addBook(Book book);

    int doBookDelete(Book book);

    Book findBookById(Integer id);

    int doEditBook(Book book);

    List<Book> findBook(Book book);
}
