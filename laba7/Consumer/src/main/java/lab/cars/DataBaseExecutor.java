package lab.cars;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseExecutor {
    private String JDBC_DRIVER = "org.postgresql.Driver";
    private String DATABASE_URL = "jdbc:postgresql://localhost:5432/gleba";
    private String DATABASE_USER = "gleb";
    private String DATABASE_PASSWORD = "111261";
    private String TABLE = "automobile";
    private Connection connection = null;
    Statement statement = null;

    public DataBaseExecutor(){

    }

    public ArrayList<Iterator> select_all(){
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Iterator> resultForReq = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            statement = connection.createStatement();
            String GET_ALL_GAMES = "SELECT * FROM " + TABLE;
            ResultSet resultSet = statement.executeQuery(GET_ALL_GAMES);
            while(resultSet.next()){
                Iterator tmp = new Iterator();
                tmp.name = resultSet.getString("name");
                tmp.studio_name = resultSet.getString("brand");
                tmp.cost = resultSet.getString("cost");
                tmp.id = Integer.parseInt(resultSet.getString("id"));
                resultForReq.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultForReq;
    }
    public void delete(String id) throws SQLException{
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        statement = connection.createStatement();
        String query = String.format(
                "DELETE FROM %1$s WHERE id = %2$s;",
                TABLE, id);
        statement.executeUpdate(query);
    }

    public void append(String name, String studio, String cost, String photo, String description) throws SQLException{
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        statement = connection.createStatement();
        String query = String.format(
                "INSERT INTO %1$s VALUES (DEFAULT, '%2$s', '%3$s', '%4$s', '%5$s', '%6$s'); ",
                TABLE, name, studio, cost, photo, description);
        statement.executeUpdate(query);

    }

    public void change(String id, String name, String studio, String cost, String photo, String description) throws SQLException{
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        statement = connection.createStatement();
        String query = String.format(
                "UPDATE %1$s SET (name, studio_name, cost, photo, description) " +
                        "= ('%2$s', '%3$s', '%4$s', '%6$s', '%7$s') WHERE id='%5$s';",
                TABLE, name, studio, cost, id, photo, description);
        System.out.println(query);
        statement.executeUpdate(query);
    }
}
