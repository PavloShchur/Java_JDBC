import utils.dbConnection.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {

    public static void main(String[] args) {
        Connection connection = null;

        try{
            connection = ConnectionConfiguration.getInstance().getConnection();
            if(connection != null && !connection.isClosed()) {
                System.out.println("Connection established.");
                Statement statement = connection.createStatement();
//                statement.execute("INSERT INTO client(FirstName, LastName, Discount) VALUES('Robert', 'Stevenson', 5)");
//                int recordId = statement.executeUpdate("UPDATE client SET LastName = 'Johnson' WHERE id = 7");
//                System.out.println("recordId: " + recordId);
//                ResultSet resultSet = statement.executeQuery("SELECT * FROM client");
                statement.addBatch("INSERT INTO client(FirstName, LastName, Discount) VALUES('Pavlo', 'Shchur', 5)");
                statement.addBatch("INSERT INTO client(FirstName, LastName, Discount) VALUES('Pavlo', 'Shchur', 5)");
                statement.addBatch("INSERT INTO client(FirstName, LastName, Discount) VALUES('Pavlo', 'Shchur', 5)");

                statement.executeBatch();
                statement.clearBatch();

                boolean isClosed = statement.isClosed();
                System.out.println("isClosed: " + isClosed);

                statement.getConnection();
                statement.close();
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
