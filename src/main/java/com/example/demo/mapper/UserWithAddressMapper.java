package com.example.demo.mapper;

import com.example.demo.model.UserWithAddress;
import com.example.demo.model.Users;
import com.example.demo.model.YourSqlProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface UserWithAddressMapper {

    @Select("SELECT * from users u join address a on u.addressid=a.addressid")
    List<UserWithAddress> findAll();


    @Select("SELECT * from users u join address a on u.addressid=a.addressid LIMIT #{pageSize} OFFSET #{offset}")
    List<UserWithAddress> findAllPaging(@Param("pageSize") int pageSize, @Param("offset") int offset);

    @Select("SELECT count(*) from users u join address a on u.addressid=a.addressid")
    int count();

    @SelectProvider(type = YourSqlProvider.class, method = "searchRecords")
    List<Users> searchRecords(@Param("field1") int field1,
                                   @Param("field2") String field2,
                                   @Param("field3") int field3);



//    SELECT *
//    FROM (
//            SELECT your_columns, ROWNUM AS row_num
//            FROM (
//            SELECT *
//            FROM your_table
//            WHERE your_conditions
//            ORDER BY your_order_column
//    )
//)
//    WHERE row_num BETWEEN :startRow AND :endRow;

//    SELECT *
//    FROM (
//            SELECT your_columns, ROWNUM AS row_num
//            FROM (
//            SELECT t1.your_columns, t2.other_columns
//                    FROM table1 t1
//                    LEFT JOIN table2 t2 ON t1.join_column = t2.join_column
//                    WHERE your_conditions
//                    ORDER BY t1.your_order_column
//    )
//)
//    WHERE row_num BETWEEN :startRow AND :endRow;



}
