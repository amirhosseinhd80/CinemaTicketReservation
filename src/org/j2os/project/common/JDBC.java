package org.j2os.project.common;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class JDBC {
    public static final int ORACLE_11G = 1;
    public static final int ORACLE_19C = 2;
    private static final BasicDataSource ORACLE_19C_BASIC_DATA_SOURCE = new BasicDataSource();
    private static final BasicDataSource ORACLE_11G_BASIC_DATA_SOURCE = new BasicDataSource();

    static {
        ORACLE_19C_BASIC_DATA_SOURCE.setUsername("amirsam");
        ORACLE_19C_BASIC_DATA_SOURCE.setPassword("myjava123");
        ORACLE_19C_BASIC_DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ORACLE_19C_BASIC_DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1521/orcl");
        ORACLE_19C_BASIC_DATA_SOURCE.setMaxTotal(10);

        /*
        ORACLE_11G_BASIC_DATA_SOURCE.setUsername("amirsam");
        ORACLE_11G_BASIC_DATA_SOURCE.setPassword("myjava123");
        ORACLE_11G_BASIC_DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ORACLE_11G_BASIC_DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        ORACLE_11G_BASIC_DATA_SOURCE.setMaxTotal(10);
        */
    }

    public static Connection getConnection(int version) throws Exception {
        Connection connection = null;
        if (version == ORACLE_19C)
            connection = ORACLE_19C_BASIC_DATA_SOURCE.getConnection();
        else
            connection = ORACLE_11G_BASIC_DATA_SOURCE.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }
}
