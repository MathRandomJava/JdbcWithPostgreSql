import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";

    private final static String USER = "postgres";

    private final static String PSWD = "root";

    private final static String SQL = "create table if not exists users ( id numeric, name varchar(20) )";

    public static void main(String[] args) {

        createUserTable();

    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(URL, USER, PSWD);
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return connection;
    }

    private static void createUserTable() {
        Connection connection = getConnection();
        if (connection != null) {

            try (Statement statement = connection.createStatement()) {
                statement.execute(SQL);
                System.out.println("Table users created");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Creating table is failed");
            }

        }
    }
}
