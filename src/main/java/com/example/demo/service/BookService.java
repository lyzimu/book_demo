package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.po.Book;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public PageInfo<Book> findBookAll(Integer pageNum,Integer size) {

        PageHelper.startPage(pageNum,size);

        List<Book> lists = bookDao.findBookAll();

        PageInfo<Book> pageInfo = new PageInfo<Book>(lists);

        return pageInfo ;
    }

    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    public int doBookDelete(Book book) {
        return bookDao.doBookDelete(book);
    }

    public Book findBookById(Integer id) {
        return bookDao.findBookById(id);
    }

    public int doEditBook(Book book) {
        return bookDao.doEditBook(book);
    }


    public PageInfo<Book> findBook(Book book, Integer pageNum, Integer size) {
        PageHelper.startPage(pageNum,size);

        List<Book> lists = bookDao.findBook(book);

        PageInfo<Book> pageInfo = new PageInfo<Book>(lists);

        return pageInfo ;
    }
}
