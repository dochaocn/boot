package com.dc.product;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JDBCTest {

    @Test
    public void jdbc() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String querySql = "select id from user where ID = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://120.79.182.70:3306/dc","root","123456");
            preparedStatement = conn.prepareStatement(querySql);
            preparedStatement.setString(1,"1");
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
