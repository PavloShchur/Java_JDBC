package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {

    public static Connection getConnection() {
        Connection connection = null;

        try{
            Class.forName(Constants.MY_SQL_DRIVER_REFERENCE);
            //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false&serverTimezone=UTC", "root", "root");
        } catch(Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
