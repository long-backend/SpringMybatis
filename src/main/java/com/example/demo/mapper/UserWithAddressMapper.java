package com.example.demo.mapper;

import com.example.demo.model.UserWithAddress;
import com.example.demo.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserWithAddressMapper {

    @Select("SELECT * from users u join address a on u.addressid=a.addressid")
    List<UserWithAddress> findAll();


    @Select("SELECT * from users u join address a on u.addressid=a.addressid LIMIT #{pageSize} OFFSET #{offset}")
    List<UserWithAddress> findAllPaging(@Param("pageSize") int pageSize, @Param("offset") int offset);

    @Select("SELECT count(*) from users u join address a on u.addressid=a.addressid")
    int count();
}
