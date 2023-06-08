package org.example.controller;

import org.example.entities.Book;
import org.example.mapper.BookMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookMapper bookMapper;

    @RequestMapping("/queryById/{id}")
    public Book queryById(@PathVariable("id") int id) {
        return bookMapper.queryBookById(id);
    }

    @RequestMapping("/queryByName/{name}")
    public Book queryByName(@PathVariable("name") String name) {
        return bookMapper.queryBookByName(name);
    }

    @RequestMapping("/queryAll")
    public List<Book> queryAll() {
        return bookMapper.queryAllBooks();
    }
}
