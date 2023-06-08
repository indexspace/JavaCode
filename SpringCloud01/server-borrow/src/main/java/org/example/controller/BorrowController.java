package org.example.controller;

import org.example.entities.BookDetail;
import org.example.entities.Borrow;
import org.example.entities.UserDetail;
import org.example.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Resource
    private BorrowService borrowService;

    @RequestMapping("/queryAll")
    public List<Borrow> queryAll(HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest.getHeaders("Test"));
        return borrowService.queryAllBorrows();
    }

    @RequestMapping("/queryById/{id}")
    public Borrow queryById(@PathVariable("id") int id) {
        return borrowService.queryBorrowById(id);
    }

    @RequestMapping("/queryByUid/{uid}")
    public UserDetail queryByUid(@PathVariable("uid") int uid) {
        return borrowService.queryUserDetail(uid);
    }

    @RequestMapping("/queryByBid/{bid}")
    public BookDetail queryByBid(@PathVariable("bid") int bid) {
        return borrowService.queryBookDetail(bid);
    }

}
