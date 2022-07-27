package com.example.demo.controller;

import com.example.demo.po.Book;
import com.example.demo.service.BookService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
//    查找所有书籍
    @RequestMapping("/findBookAll")
    public String findBookAll(Model model,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,@RequestParam(value = "size",defaultValue = "4") Integer size){
        PageInfo<Book> books = bookService.findBookAll(pageNum,size);
        model.addAttribute("books",books);
        return "main.html";
    }
//   （修改时） 按id查找书籍 跳转至修改页面
    @RequestMapping("/findBookById")
    public String findBookById(Model model,Integer id){
        Book book = bookService.findBookById(id);
        model.addAttribute("book",book);
        return "BookEdit.html";
    }
//    查询所有的书籍（做模糊查询时可用）
    @RequestMapping("/findBook")
    public String findBook(Model model,Book book,@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,@RequestParam(value = "size",defaultValue = "4") Integer size){
        PageInfo<Book> books = bookService.findBook(book,pageNum,size);
        model.addAttribute("books",books);
        return "main.html";
    }
//    添加书籍
    @RequestMapping("/doAddBook")
    public String doAddBook(Model model,Book book){
        int i = bookService.addBook(book);
        return "redirect:findBookAll";
    }
//    添加页面的跳转
    @RequestMapping("/BookAdd")
    public String BookAdd(){
         return "BookAdd.html";
    }
//    删除书籍
    @RequestMapping("/doBookDelete")
    public String doBookDelete(Model model,Book book){
        int i = bookService.doBookDelete(book);
        return "redirect:findBookAll";
    }
//    修改书籍
    @RequestMapping("/doEditBook")
    public String doEditBook(Model model,Book book){
        int i = bookService.doEditBook(book);
        return "redirect:findBookAll";
    }
}
