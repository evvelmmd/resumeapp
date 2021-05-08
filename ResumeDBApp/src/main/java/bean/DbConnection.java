package bean;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public static Connection connect() throws Exception{
        String url ="jdbc:mysql://localhost:3306/resume";
        String user="root";
        String password="";
       // Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(url,user,password);
        return c;
    }
}
