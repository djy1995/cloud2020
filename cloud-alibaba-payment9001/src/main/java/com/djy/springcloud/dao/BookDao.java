package com.djy.springcloud.dao;

import com.djy.springcloud.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BookDao {

    //    @Select("select * from book where id = #{id}")
    public Book findBookById(int id);


    public int insertBook(Book book);
}
