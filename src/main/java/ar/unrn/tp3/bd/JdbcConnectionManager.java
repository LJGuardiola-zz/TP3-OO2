package ar.unrn.tp3.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class JdbcConnectionManager {

    private static final JdbcConnectionManager INSTANCE = new JdbcConnectionManager();

    static JdbcConnectionManager getInstance() {
        return INSTANCE;
    }

    Connection getConnection() throws SQLException {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:derby:db");
        } catch (SQLException e) {
            connection = DriverManager.getConnection("jdbc:derby:db;create=true");
            setupDB(connection);
        }
        return connection;
    }

    private void setupDB(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "create table PARTICIPANTS ( " +
                        "ID int generated always as identity constraint PARTICIPANTS_PK primary key, " +
                        "NAME VARCHAR(80) not null, " +
                        "PHONE VARCHAR(15) not null, " +
                        "REGION VARCHAR(20) not null " +
                    ")"
        );
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}
