package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.entities.Borrow;

import java.util.List;

@Mapper
public interface BorrowMapper {

    @Select("select * from borrow")
    public List<Borrow> queryAllBorrows();

    @Select("select * from borrow where id = #{id}")
    public Borrow queryBorrowById(int id);

    @Select("select * from borrow where uid = #{uid}")
    public List<Borrow> queryBorrowByUid(int uid);

    @Select("select * from borrow where bid = #{bid}")
    public List<Borrow> queryBorrowByBid(int bid);
}
