package org.example.controller;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import io.vertx.core.net.impl.pool.ConnectionPool;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.TearDown;

import javax.management.JMX;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;

public final class HikariCPDataSource {
    // connections
    protected HikariDataSource pool;

    @Param({"mariadb"})
    String driver;

    @Param({"100"})
    int numberOfTasks;

    @Param({"16"})
    int numberOfConnection;

    @Setup(Level.Trial)
    public void createConnections() throws Exception {

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(
                ("mariadb".equals(driver) ? "org.mariadb.jdbc.Driver" : "org.mariadb.jdbc.Driver"));
        config.setJdbcUrl(String.format("jdbc:%s://mysql-main.dev.aws.internal", "mariadb"));
        config.setUsername("user_cstern_dev_aws");
        config.setPassword("1e3cb2a1-f5a2-47b4-ab69-36daec8582c8");
        // in order to compare the same thing with mysql and mariadb driver,
        config.addDataSourceProperty("sslMode", "DISABLED");
        config.addDataSourceProperty("serverTimezone", "UTC");

        config.setMaximumPoolSize(20);
        config.setPoolName("foo");
        //config.setRegisterMbeans(true);
        pool = new HikariDataSource(config);


    }

    @TearDown(Level.Trial)
    public void doTearDown() throws SQLException {
        pool.close();
    }

}
