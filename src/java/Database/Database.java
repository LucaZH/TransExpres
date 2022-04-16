package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author luca
 */
public class Database {

    private Connection conn;
    protected PreparedStatement ps = null;

    public Connection Connect() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/transport", "root", "");
                System.out.println("Connection succesful ");
            } catch (Exception e) {
                System.out.println("connection fail");
                System.out.println(e);
            }
        }
        return conn;
    }
    
}
