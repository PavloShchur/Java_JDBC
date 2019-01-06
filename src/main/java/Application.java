import utils.dbConnection.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) {
        Connection connection = null;

        try{
            connection = ConnectionConfiguration.getInstance().getConnection();
            if(connection != null && !connection.isClosed()) {
                System.out.println("Connection established.");
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                    if(connection.isClosed()) {
                        System.out.println("Connection is closed.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
