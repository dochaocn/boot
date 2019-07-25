package com.dc.demo;


import cn.hutool.db.sql.SqlExecutor;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class Main {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String querySql = "select id from user where ID = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://120.79.182.70:3306/dc","root","123456");
            preparedStatement = conn.prepareStatement(querySql);
            preparedStatement.setString(1,args[0]);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               log.info(resultSet.getString(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            log.error(e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
                if (preparedStatement != null) preparedStatement.close();
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
    }

}

//    double a = 1.1;
//    double b = 0.1;
//    System.out.println(a + b);
