package org.example.service;

import org.example.entities.BookDetail;
import org.example.entities.Borrow;
import org.example.entities.UserDetail;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BorrowService {

    List<Borrow> queryAllBorrows();

    public Borrow queryBorrowById(int id);

    public UserDetail queryUserDetail(int uid);

    public BookDetail queryBookDetail(int bid);

}
