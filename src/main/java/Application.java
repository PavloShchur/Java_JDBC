import utils.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.SQLException;

public class Application {

    public static void main(String[] args) {
        Connection connection = null;

        try{
            connection = ConnectionConfiguration.getInstance().getConnection();
            if(connection != null) {
                System.out.println("Connection established.");
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
