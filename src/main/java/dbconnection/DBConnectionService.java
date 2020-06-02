package dbconnection;

import com.mysql.jdbc.Driver;
import utility.ApplicationConst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionService {

    public static Connection getConnection() throws Exception {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(ApplicationConst.URL, ApplicationConst.USER, ApplicationConst.PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}
