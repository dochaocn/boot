package com.dc.demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {

    @Autowired
    ApplicationContext ioc ;

    @Autowired
    DataSource dataSource;

    @Test
    public void testDataSourceType() throws SQLException {
        DruidDataSource dataSource = (DruidDataSource) this.dataSource;
        System.out.println(dataSource.getClass());



        for (int i = 0; i < 100; i++){
            Connection connection = dataSource.getConnection();
            System.out.println(i);
            System.out.println(connection);
            connection.close();
        }

        Map<String, Object> map = dataSource.getStatDataForMBean();
        System.out.println(map.toString());
    }


}
