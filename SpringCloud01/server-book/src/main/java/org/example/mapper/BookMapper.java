package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.entities.Book;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("select * from book")
    public List<Book> queryAllBooks();

    @Select("select * from book where id = #{id}")
    public Book queryBookById(int id);

    @Select("select * from book where name = #{name}")
    public Book queryBookByName(String name);


}
