package com.connect;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.*;

public class Main {

    public static void main(String[] args) throws Exception{
        DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        /*
        Connection conn = DriverManager.getConnection("jdbc:postgresql://194.87.214.180/babanov", "webadmin", "FSBrid52282");
        Statement statement = conn.createStatement();
        statement.executeQuery("CREATE TABLE message (id SERIAL, name text, message text)");
        */
        //194.87.214.180
    }
}
