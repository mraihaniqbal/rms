package com.mitrais.rms.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class provides MySQL datasource to be used to connect to database.
 * It implements singleton pattern See <a href="http://www.oodesign.com/singleton-pattern.html">Singleton Pattern</a>
 */
public class DataSourceFactory
{
    private final DataSource dataSource;

    DataSourceFactory()
    {

        MysqlDataSource dataSource = new MysqlDataSource();
        // TODO: make these database setting configurable by moving to properties file
        Properties prop = new Properties();
        try{
            prop.load(getClass().getResourceAsStream("/database.properties"));

            dataSource.setDatabaseName(prop.getProperty("db.name"));
            dataSource.setServerName(prop.getProperty("db.server"));
            dataSource.setPort(Integer.parseInt(prop.getProperty("db.port")));
            dataSource.setUser(prop.getProperty("db.username"));
            dataSource.setPassword(prop.getProperty("db.password"));

        }catch (IOException e){
            System.out.println("File tidak ditemukan");
            e.printStackTrace();
        }

        this.dataSource = dataSource;
    }

    /**
     * Get a data source to database
     *
     * @return DataSource object
     */
    public static Connection getConnection() throws SQLException
    {
        return SingletonHelper.INSTANCE.dataSource.getConnection();
    }

    private static class SingletonHelper
    {
        private static final DataSourceFactory INSTANCE = new DataSourceFactory();
    }
}
