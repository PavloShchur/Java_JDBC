package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {

    private static ConnectionConfiguration connectionConfiguration;
    private static Connection connection;

    private ConnectionConfiguration() {}

    public static ConnectionConfiguration getInstance() {
        if(connectionConfiguration == null) connectionConfiguration = new ConnectionConfiguration();
        return connectionConfiguration;
    }

    public Connection getConnection() {
        try{
            Class.forName(Constants.MY_SQL_DRIVER_REFERENCE);
            if(connection == null) connection = DriverManager.getConnection(Constants.MY_SQL_URL, Constants.MY_SQL_USER_NAME, Constants.MY_SQL_PASSWORD);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
