import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


@WebServlet(name = "Servlet", urlPatterns = {"/"})
public class Servlet extends HttpServlet {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/gleba";
    private static final String DATABASE_USER = "gleb";
    private static final String DATABASE_PASSWORD = "111261";
    private static final String AUTOMOBILE = "automobile";
    private static final String GET_ALL = "SELECT * FROM automobile";
    private Connection connection = null;
    Statement statement = null;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("resultSet", select_all());
        request.getRequestDispatcher("/start.jsp").forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch(request.getParameter("button")){
            case "delete":
                delete(request.getParameter("id"));
                break;
            case "change":
                change(request.getParameter("id"), request.getParameter("name"), request.getParameter("brand"), request.getParameter("cost"));
                break;
            case "add":
                add(request.getParameter("name"), request.getParameter("brand"), request.getParameter("cost"));
                break;
            default:
                break;
        }
        request.setAttribute("resultSet", select_all());
        request.getRequestDispatcher("/start.jsp").forward(request, response);
    }

    private ArrayList<String[]> select_all(){
        ArrayList<String[]> resultForReq = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while(resultSet.next()){
                String[] tmp = new String[4];
                tmp[0] = resultSet.getString("name");
                tmp[1] = resultSet.getString("brand");
                tmp[2] = resultSet.getString("cost");
                tmp[3] = resultSet.getString("id");
                resultForReq.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultForReq;
    }

    private void add(String name, String studio, String cost) throws ServletException, IOException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            statement = connection.createStatement();
            String query = String.format(
                    "INSERT INTO %1$s VALUES (DEFAULT, '%2$s', '%3$s', '%4$s', null, null); ",
                    AUTOMOBILE, name, studio, cost);
            statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void change(String id, String name, String studio, String cost){
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            statement = connection.createStatement();
            String query = String.format(
                    "UPDATE %1$s SET (id, name, brand, cost) = (%5$s, '%2$s', '%3$s', '%4$s') WHERE id=%5$s;",
                    AUTOMOBILE, name, studio, cost, id);
            statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void delete(String id){
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            statement = connection.createStatement();
            String query = String.format(
                    "DELETE FROM %1$s WHERE id = %2$s;",
                    AUTOMOBILE, id);
            statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}