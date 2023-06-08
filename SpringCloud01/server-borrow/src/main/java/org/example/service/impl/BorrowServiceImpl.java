package org.example.service.impl;

import org.example.entities.*;
import org.example.mapper.BorrowMapper;
import org.example.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    private BorrowMapper borrowMapper;

    @Resource
    private RestTemplate restTemplate;


    @Override
    public List<Borrow> queryAllBorrows() {
        return borrowMapper.queryAllBorrows();
    }

    @Override
    public Borrow queryBorrowById(int id) {
        return borrowMapper.queryBorrowById(id);
    }

    @Override
    public UserDetail queryUserDetail(int uid) {
        List<Borrow> borrows = borrowMapper.queryBorrowByUid(uid);
        MyUser user = restTemplate.getForObject(
                "http://userService/user/queryById/" + uid, MyUser.class);
        List<Book> books = borrows.stream()
                .map(b -> restTemplate.getForObject(
                        "http://bookService/book/queryById/" + b.getBId(), Book.class))
                .collect(Collectors.toList());
        return new UserDetail(user, books);
    }

    @Override
    public BookDetail queryBookDetail(int bid) {
        List<Borrow> borrows = borrowMapper.queryBorrowByBid(bid);
        RestTemplate restTemplate = new RestTemplate();
        Book book = restTemplate.getForObject(
                "http://localhost:8002/book/queryById/" + bid, Book.class);
        List<MyUser> users = borrows.stream()
                .map(b -> restTemplate.getForObject(
                        "http://localhost:8001/user/queryById/" + b.getUid(), MyUser.class))
                .collect(Collectors.toList());
        return new BookDetail(book, users);
    }
}
