package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDerbyBD {

        private static final String URL = "jdbc:derby:dbteste;create=true";

        public static Connection getConnection () throws SQLException {
            return DriverManager.getConnection(URL);
        }

}