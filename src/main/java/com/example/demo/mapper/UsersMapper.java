package com.example.demo.mapper;

import com.example.demo.model.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Select("select * from users")
    List<Users> findAll();

    @Insert("insert into users(name,salary,addressid,difficultcode) values(#{name},#{salary},#{addressid},#{difficultcode})")
//    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
//            before = false, resultType = Integer.class)
    void insert(Users users);

    @Delete("delete from users where id=#{id}")
    int deleteAll(@Param("id") int id);

    @Update("update users set name=#{name} , salary =#{salary}, addressid=#{addressid},difficultcode=#{difficultcode} where id=#{id}")
    int updateUser(Users users);

    @Select("select * from users")
    List<Users> getUserWithPaging();

    @Select("select * from users where id=#{id}")
    Users getUser(@Param("id") int id);

}
