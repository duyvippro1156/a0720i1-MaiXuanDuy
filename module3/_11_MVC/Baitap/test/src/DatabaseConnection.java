import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
	private final static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=studentmanager;"
            + "integratedSecurity=true";
    private final static String USER_NAME = "sa";
    private final static String PASSWORD = "123";
    
    
    public  static void Connect() {
    try {
        // connnect to database 'studentmanager'
        Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        // create statement
        Statement stmt = conn.createStatement();
        // get data from table 'student'
        ResultSet rs = stmt.executeQuery("select * from student");
        // show data
        while (rs.next()) {
            System.out.println(rs.getInt(1) + "  " + rs.getString(2) 
                    + "  " + rs.getString(3));
        }
        // close connection
        conn.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }


/**
 * create connection 
 * 
 * @author viettuts.vn
 * @param dbURL: database's url
 * @param userName: username is used to login
 * @param password: password is used to login
 * @return connection
 */
public static java.sql.Connection getConnection(String dbURL, String userName, 
        String password) {
    Connection conn = null;
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(dbURL);
        System.out.println("connect successfully!");
    } catch (Exception ex) {
        System.out.println("connect failure!");
        ex.printStackTrace();
    }
    return conn;
}
}
