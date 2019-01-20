package dao.workerDao;

import dao.workerDao.constants.WorkerSelectorConstants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClientSelector {

    public static ResultSet selectClientById(Statement statement, List<String> fields, String id) throws SQLException {
        ResultSet resultSet = null;

        if(statement == null || fields == null || fields.isEmpty()) return resultSet;

        resultSet = statement.executeQuery("SELECT " + String.join(",", fields) + " FROM client WHERE id = " + id);

        return resultSet;
    }

    public static ResultSet selectClients(Statement statement, List<String> fields) throws SQLException {
        ResultSet resultSet = null;

        if(statement == null || fields == null || fields.isEmpty()) return resultSet;

        resultSet = statement.executeQuery("SELECT " + String.join(",", fields) + " FROM client");

        return resultSet;
    }
}
