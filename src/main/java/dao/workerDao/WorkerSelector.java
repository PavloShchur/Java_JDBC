package dao.workerDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class WorkerSelector {

    public static ResultSet selectWorkerById(Statement statement, List<String> fields, String id) throws SQLException {
        ResultSet resultSet = null;

        if(statement == null || fields == null || fields.isEmpty()) return resultSet;

        resultSet = statement.executeQuery("SELECT " + String.join(",", fields) + " FROM worker WHERE id = " + id);

        return resultSet;
    }

    public static ResultSet selectWorkers(Statement statement, List<String> fields) throws SQLException {
        ResultSet resultSet = null;

        if(statement == null || fields == null || fields.isEmpty()) return resultSet;

        resultSet = statement.executeQuery("SELECT " + String.join(",", fields) + " FROM worker");

        return resultSet;
    }
}
