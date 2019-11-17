package com.f.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

public class C3p0 {
    Logger logger = LoggerFactory.getLogger(getClass());

    public static ComboPooledDataSource getDatasource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/foo?useSSL=false&useUnicode=true&characterEncoding=UTF-8&verifyServerCertificate=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai");
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setInitialPoolSize(5);
        dataSource.setMinPoolSize(5);
        dataSource.setAcquireIncrement(5);
        dataSource.setMaxPoolSize(20);
        dataSource.setMaxStatements(100);
        return dataSource;
    }

    @Test
    void name() {
        logger.info("获取 datasource...");
        DataSource dataSource = getDatasource();
        logger.info("datasource null? {}", dataSource == null);

        QueryRunner queryRunner = new QueryRunner(dataSource);
        logger.info("获取 runner");
        assertNotNull(queryRunner);
        logger.info("runner is null?{}", queryRunner == null);
        try (Connection connection1 = JDBCUtil.getConnection()) {
            logger.info("执行更新语句....");
            var result = queryRunner.update(connection1, "insert into users(username, passwd) values(aaaa, 1)");
            logger.info("更新结果为: {}", result);
        } catch (Exception e) {

        }
    }

    @Test
    void name1() {
        logger.info("info");
        logger.debug("debug");
        System.out.println("hello");
    }
}
