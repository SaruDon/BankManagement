import java.sql.*;

public class Conn {
    public Connection c;
    public Statement s;

    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "SarveshKhamkar123.");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
