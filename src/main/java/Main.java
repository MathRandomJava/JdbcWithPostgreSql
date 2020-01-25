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

    private static Connection getConnection() throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path");
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PSWD);
    }

    private static void createUserTable() {
        try (Connection connection = getConnection()) {
            if (connection != null) {

                try (Statement statement = connection.createStatement()) {
                    statement.execute(SQL);
                    System.out.println("Table users created or already exists");
                }

            }
        } catch (SQLException e) {
            System.out.println("Creating table is failed");
            e.printStackTrace();
        }
    }
}
