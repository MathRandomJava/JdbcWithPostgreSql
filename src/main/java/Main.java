import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";

    private final static String USER = "postgres";

    private final static String PSWD = "root";

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        try (Connection connection = DriverManager
                .getConnection(URL, USER, PSWD)) {

           if (connection != null) {
                System.out.println("Connection successfully");
            } else {
                System.out.println("Connection failed");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
    }
}
