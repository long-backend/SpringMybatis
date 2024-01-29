package com.example.demo.model;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

 public class YourSqlProvider {
    public String searchRecords(Map<String, Object> params) {
        StringBuilder sql = new StringBuilder("SELECT * FROM users WHERE ");


        sql.append("(1 = 1) "); // Điều kiện trống sẽ trả về TRUE

        if ((Integer) params.get("field1") != 0) {
            sql.append("AND id = #{field1}  ");
        }

        if (params.get("field2") != null) {
            sql.append( " AND name = #{field2}  ");
        }

        if ( (Integer)params.get("field3") != 0 ) {
            sql.append("AND salary = #{field3}");
        }

        // Remove the trailing "AND" if it exists
//        if (sql.toString().endsWith("AND ")) {
//            sql.setLength(sql.length() - 4);
//        }

        return sql.toString();
    }
}
